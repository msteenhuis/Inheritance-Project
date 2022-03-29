import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
import java.util.function.LongFunction;

public class LocalVolumeManager {

    private String name;
    private int size;
    private String uuid;

    public LocalVolumeManager()
    {
    }

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
    public int getSize()
    {
        return size;
    }
// Returns the drive size of the object.
    public String getUuid()
    {
         return uuid;
    }
// Returns the uuid of the object.

    public void save()
    {
        //save work on file
    }

    public void Interface(String v)
    {
        String out = "";
        while(!v.equals("exit")) {
            Scanner input = new Scanner(System.in);
            if (v.equals("1")) {


                System.out.println("Input the name of your Hard Drive: ");
                String n = input.next();
                System.out.println("Input the size of your Hard Drive in GB: ");
                int s = input.nextInt();
                HardDrive tempHD = new HardDrive(n, s);
                hdArr.add(tempHD);
                System.out.println("Hard Drive installed!");


            }
            if (v.equals("2")) {


                {
                    for (HardDrive val : hdArr)
                    {
                        System.out.println(val.getName() + "[" + val.getSize() + " GB]");
                    }
                }


            }
            if (v.equals("3")) {
                HardDrive h = null;
                System.out.println("Input the name of your Physical Volume: ");
                String n = input.next();
                String u = UUID.randomUUID() + "";
                PhysicalVolume temp = new PhysicalVolume(n, u, h);
                System.out.println("Enter the name of the Hard Drive you would like to set to the Physical Volume. Below is a list of installed Hard Drives: ");
                for (HardDrive val : hdArr)
                {
                    System.out.print(val.getName() + ", ");
                }
                System.out.println();
                String e = input.next();
                boolean output = temp.hdCheck(e);
                while (output == false) {
                    System.out.println("Please re-enter the name of the Hard Drive: ");
                    e = input.next();
                    output = temp.hdCheck(e);
                }
                temp.setDrive(e);
                pvArr.add(temp);
                System.out.println("Physical Volume installed!");


            }
            if (v.equals("4")) {


                for (VolumeGroup val : vgArr) //Physical Volumes
                {
                        System.out.println(val.getP().getName() + ": " + "[" + val.getP().getDrive().getSize() + " GB] " + "[" + val.getName() + "] " + "[" + val.getUuid() + "]");
                }
                System.out.println("If there are no Physical Volumes shown, you may need to update your Volume Groups.");


            }
            if (v.equals("5")) {


                System.out.println("To add a new Volume Group, enter V. \nTo add a new Physical Drive to the Volume Group, enter P: ");
                String choice = input.next();
                if (choice.equals("V")) {
                    PhysicalVolume p = null;
                    System.out.println("Input the size of your Volume Group in GB: ");
                    int s = input.nextInt();
                    System.out.println("Input the name of your Volume Group: ");
                    String n = input.next();
                    String u = UUID.randomUUID() + "";
                    System.out.println("Input the number of Physical Volumes you would like to be installed on your Volume Group: ");
                    int r = input.nextInt();
                    System.out.println("Below is a list of installed Physical Volumes: ");
                    for (PhysicalVolume val : pvArr) {
                        System.out.print(val.getName() + ", ");
                    }
                    System.out.println();
                    VolumeGroup temp = new VolumeGroup(n, s, u, p);
                    for (int i = 1; i < r + 1; i++) {
                        System.out.println("Please enter the name of Physical Drive " + i + ": ");
                        String e = input.next();
                        boolean output = temp.vgCheck(e);
                        while (output == false) {
                            System.out.println("Please re-enter the name of the Physical Drive: ");
                            e = input.next();
                            output = temp.vgCheck(e);
                        }
                        temp.add(e);
                    }
                    vgArr.add(temp);
                }
                if (choice.equals("P")) {
                    VolumeGroup tempVG  = null;
                    System.out.println("Enter the name of the Volume Group you would like to add to. Below is a list of installed Volume Groups");
                    for (VolumeGroup val : vgArr) {
                        System.out.print(val.getName() + ", ");
                    }
                    String e = input.next();
                    for (VolumeGroup val : vgArr)
                    {
                        if (val.getName().equals(e))
                        {
                            tempVG = val;
                        }
                    }
                    System.out.println("Input the number of Physical Volumes you would like to be installed on your Volume Group: ");
                    int r = input.nextInt();
                    System.out.println("Enter the name/s of the Physical Volumes you would like to set to the Volume Group. Below is a list of installed Physical Volumes: ");
                    for (PhysicalVolume val : pvArr) {
                        System.out.print(val.getName() + ", ");
                    }
                    for (int i = 1; i < r + 1; i++) {
                        System.out.println("Please enter the name of Physical Drive " + i + ": ");
                        boolean output = tempVG.vgCheck(e);
                        while (output == false) {
                            System.out.println("Please re-enter the name of the Physical Drive: ");
                            e = input.next();
                            output = tempVG.vgCheck(e);
                        }
                        tempVG.add(e);
                    }
                }
            }

            if (v.equals("6")) {
                for (VolumeGroup val : vgArr)
                {
                    System.out.println(val.getName() + ": " + "[ " + val.getSize() + " ]" + " [ " + val.getStorage() + " ]" + " [" + val.getPvStore() + " ]" + "[ " + val.getUuid() + " ]");
                }
            }
            if (v.equals("7")) {
                int vgStorage = 0;
                VolumeGroup vg = null;
                int s = 0;
                System.out.println("Input the name of your Logical Volume: ");
                String n = input.next();
                String u = UUID.randomUUID() + "";
                LogicalVolume tempLv = new LogicalVolume(n, s, u, vg);
                System.out.println("Enter the name of the Volume Group you would like to set to the Logical Volume. Below is a list of installed Volume Groups: ");
                for (VolumeGroup val : vgArr)
                {
                    System.out.print(val.getName() + ", ");
                }
                String e = input.next();
                boolean output = tempLv.vgCheck(e);
                while (output == false) {
                    System.out.println("Please re-enter the name of the Hard Drive: ");
                    e = input.next();
                    output = tempLv.vgCheck(e);
                }
                tempLv.setVol(e);
                System.out.println("Enter the size of the Logical Volume. Note: The Volume Group installed to the Logical Group only has " + tempLv.getVol().getStorage() + " GB left.");
                int f = input.nextInt();
                while (f > tempLv.getVol().getStorage())
                {
                    System.out.println("Error: Volume Group does not have enough storage for that size. Please input a smaller number:");
                    f = input.nextInt();
                }
                s = f;
                lvArr.add(tempLv);


            }
            if (v.equals("8")) {
                for (LogicalVolume val : lvArr)
                {
                    System.out.println(val.getName() + ": [ " + val.getSize() + " ] " + " [ " + val.getVol() + " ]" + "[ " + val.getUuid() + " ]");
                }
            }
            if (v.equals("exit"))
            {
                this.save();
            }
            break;
        }


    }
//Gives user a series of options to chose from, as seen in the Runner Class

}
