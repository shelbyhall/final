import java.io.File;
import java.util.Scanner;

public class InventoryProcess {

public static void main(String[] args) {
  
String userNames[]=new String[100];
String passWords[]=new String[100];
int n=getDataFromFile("userLoginData.txt",userNames,passWords);
  
UserManagement userManagement=new UserManagement("users.txt");
InventoryManagement inventoryManagement=new InventoryManagement("inventory.txt");

String Report[]=new String[100];
int entry=0;
Scanner input=new Scanner(System.in);
System.out.println("Enter User Name: ");
String username=input.next();
System.out.println("Enter password: ");
String password=input.next();
Authenticate(username,password);
boolean flag;
while(true){
int choice=SelectActivity();
int option;
switch(choice)
{
case 1: option=userManagement.UserManagementChoices();
switch(option)
{
case 1: userManagement.DisplayAllUsers();
break;
case 2: userManagement.AddNewUser();
Report[entry++]="New User Added by "+username;
break;
case 3: flag=userManagement.UpdateExistingUser();
if(flag==false){
System.out.println("User name doesn't exist");
}
else
Report[entry++]="User details updated "+username;
break;
case 4: flag=userManagement.DeleteExistingUsers();
if(flag==false){
System.out.println("User name doesn't exist");
}
else
Report[entry++]="User details deleted by "+username;
break;
}
break;
case 2: option=inventoryManagement.InventoryManagementChoices();
switch(option)
{
case 1: inventoryManagement.DisplayInventory();break;
case 2: inventoryManagement.AddNewItem();
Report[entry++]="New Item Added by "+username;
break;
case 3: flag=inventoryManagement.updateInventory();
if(flag==false){
System.out.println("Item name doesn't exist");
}
else
Report[entry++]="Item details updated "+username;
break;
case 4: flag=inventoryManagement.DeleteInventoryItem();
if(flag==false){
System.out.println("Item name doesn't exist");
}
else
Report[entry++]="Item details deleted "+username;
break;
}
break;
  
case 3: GenerateReport(Report,entry); break;
case 4: System.exit(0);
}
}
}
private static int SelectActivity ()
{
System.out.println("1. User Management");
System.out.println("2. Inventory Management");
System.out.println("3. Generate Report");
System.out.println("4. Logout");
System.out.println("Enter your choice: ");
Scanner console=new Scanner(System.in);
int choice=console.nextInt();
return choice;
  
}

private static void Authenticate(String username, String password) {
  
}


private static int getDataFromFile(String filename, String[] userNames, String[] passWords) {
String name;
String pass;
int n=0;
try{
Scanner infile=new Scanner(new File(filename));
while(infile.hasNextLine())
{
userNames[n]=infile.next();
passWords[n]=infile.next();
n++;
  
}

}
catch(Exception e)
{
}
return n;
}

private static void GenerateReport(String[] Report, int entry) {
System.out.println("Report");
for(int i=0;i<entry;i++)
{
System.out.println(Report[i]);
}
}
  
  
}
