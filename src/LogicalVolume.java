public class LogicalVolume extends LocalVolumeManager{

    private VolumeGroup vol;

    private LogicalVolume(String n, int s, String u, VolumeGroup v)
    {
        super(n, s, u);
        this.vol = v;
    }

    public void add(LogicalVolume l)
    {
        lvArr.add(l);
    }

    public boolean vgSet(VolumeGroup v)
    {
    }
}
