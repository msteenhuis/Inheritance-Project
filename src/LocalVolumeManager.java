import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;

public class LocalVolumeManager {

    private String name;
    private int size;
    private String uuid;

    public LocalVolumeManager(String n, String u)
    {
        this.name = n;
        this.uuid = u;
        uuid = UUID.randomUUID() + "";
    }

    public LocalVolumeManager(String n, int s, String u)
    {
        this.name = n;
        this.size = s;
        this.uuid = u;
        uuid = UUID.randomUUID() + "";
    }

    public LocalVolumeManager(String n, int s)
    {
        this.name = n;
        this.size = s;
    }

    ArrayList<HardDrive> hdArr = new ArrayList();
    ArrayList<PhysicalVolume> pvArr = new ArrayList();
    ArrayList<VolumeGroup> vgArr = new ArrayList();
    ArrayList<LogicalVolume> lvArr = new ArrayList();

    public String getName()
    {
        return name;
    }
// Returns the name of the object.
    public String getSize()
    {
        return size + "GB";
    }
// Returns the drive size of the object.
    public String getUuid()
    {
         return uuid;
    }
// Returns the uuid of the object.

    public void Interface(Scanner v)
    {
        Scanner input = new Scanner(System.in);
        if (v.equals("1"))
        {
            System.out.println("Input the name of your Hard Drive: ");
            String n = input.next();
            System.out.println("Input the size of your Hard Drive in GB: ");
            int s = input.nextInt();
            HardDrive tempHD = new HardDrive(n, s);
            hdArr.add(tempHD);
        }
        if (v.equals("2"))
        {

        }
        if (v.equals("3"))
        {
            System.out.println("Input the name of your Physical Volume: ");
            String n = input.next();
            String u = UUID.randomUUID() + "";
            System.out.println("Enter the name of the Hard Drive you would like to set to the Physical Volume. Below is a list of installed Hard Drives: ");
            for (HardDrive v : hdArr)
            {
                System.out.print("\\u001B[36m" + "");
                System.out.print(v + ", ");
                System.out.print("\u001b[0m");
            }
            String h = input.next();
            hdSet
            PhysicalVolume( n, u, h);
            hdArr.add(tempHD);
        }
        if (v.equals("4"))
        {

        }
        if (v.equals("5"))
        {

        }
        if (v.equals("6"))
        {

        }
        if (v.equals("7"))
        {

        }
        if (v.equals("8"))
        {

        }
        if (v.equals("exit"))
        {

        }
    }
//Gives user a series of options to chose from, as seen in the Runner Class

}