public class LogicalVolume extends LocalVolumeManager{

    private VolumeGroup vol;

    public LogicalVolume(String n, int s, String u, VolumeGroup v)
    {
        super(n, s, u);
        this.vol = v;
    }

    public void add(LogicalVolume l)
    {
        lvArr.add(l);
    }

    public VolumeGroup getVol()
    {
        return vol;
    }

    public void setVol(String val)
    {
        for (VolumeGroup v : vgArr)
        {
            if (v.getName().equals(val))
            {
                vol = v;
            }
        }
    }

    public boolean vgCheck(String v)
    {
        boolean output = false;
        for (VolumeGroup val : vgArr)
        {
            if (val.getName().equals(v)) //VolumeGroup must exist
            {
                if(val.getName().indexOf(val.getLvStore()) == -1)   //VolumeGroup must not have duplicate LogicalVolume
                {
                    if (val.getStorage() > 0)
                    {
                        output = true;
                    }
                }
            }
        }
        return output;
    }
}
