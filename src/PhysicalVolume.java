public class PhysicalVolume extends LocalVolumeManager{

    private HardDrive drive;
    public PhysicalVolume(String n, String u, HardDrive h)
    {
        super(n, u);
        this.drive = h;
    }

    public void add(PhysicalVolume p)
    {
        pvArr.add(p);
    }

    public HardDrive getDrive()
    {
        return drive;
    }

    public void hdSet(String d)
    {
        for(int i = 0; i < hdArr.size(); i++)
        {
            if (hdArr.get(i).getName().equals(d))
            {
                for (int j = 0; j < pvArr.size(); j++)
                {
                    if(pvArr.get(j).getName().equals(d))
                    {
                        System.out.println("Error: Hard Drive already set to Physical Drive.");
                        break;
                    }
                    pvArr.add(pvArr.get(j));
                }
            }
        }

        System.out.println(d + " is now attached to Physical Volume: " + super.getName());
    }

}
