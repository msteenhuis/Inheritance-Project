import java.util.ArrayList;

public class VolumeGroup extends LocalVolumeManager{

    private String pvInitial;
    private PhysicalVolume p;
    private ArrayList<PhysicalVolume> pvStore = new ArrayList();
    private ArrayList<LogicalVolume> lvStore = new ArrayList();

    public VolumeGroup(String n, int s, String u, PhysicalVolume p)
    {
        super(n, s, u);
        this.p = p;

    }

    public void add(String v)
    {
        for (PhysicalVolume val : pvArr)
        if(val.getName().equals(v))
        {
            pvStore.add(val);
        }
    }

    public String getPvStore()
    {
        String output = "";
        for (PhysicalVolume v : pvStore)
        {
            output += v.getName() + ", ";
        }
        return output;
    }

    public String getLvStore()
    {
        String output = "";
        for (LogicalVolume v : lvStore)
        {
            output += v.getName() + ", ";
        }
        return output;
    }

    public PhysicalVolume getP()
    {
        return p;
    }

    public boolean hasPV()
    {
        boolean output = true;
        if(this.getP() == null)
        {
            output = false;
        }
        return output;
    }

    public int getStorage()
    {
        int storage = 0;
        for (PhysicalVolume v : pvStore)
        {
            storage += v.getDrive().getSize();
        }
        int output = this.getSize() - storage;
        return output;
    }

    public void lvSet(PhysicalVolume p)
    {
        for(int i = 0; i < pvArr.size(); i++)
        {
            if (pvArr.get(i).getName() == p.getName())
            {
                break;
            }
        }
        for (int i = 0; i < vgArr.size(); i++)
        {
            if(pvArr.get(i).getDrive().equals(p.getName()))
            {
                break;
            }
        }
        pvStore.add(p);
        System.out.println(p.getName() + " is now attached to Volume Group: " + super.getName());
    }


    public boolean vgCheck(String l) //(1. must be specified) (2.cannot be installed any VG) (3.VG must have enough storage left)
    {
        boolean output = true;
        for(int i = 0; i < lvArr.size(); i++) {
            if (lvArr.get(i).getName().equals(l)) {
                for (int j = 0; j < pvStore.size(); j++) {
                    if (pvStore.get(j).getName().equals(l)) {
                        output = false;
                        System.out.println("Error: Hard Drive already set to Physical Drive.");
                    }
                    if (this.getStorage() < lvArr.get(i).getSize())
                    {
                        output = false;
                        System.out.println("Error: Volume Group does not have enough storage.");
                        //pvArr.add(pvArr.get(j));
                    }
                }
            }
        }
        return output;
    }

}
