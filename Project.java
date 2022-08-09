package simplilearnproj;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Project {
	//File to retrieve from specified path start
	static void Direct (File[] arr, int index)
	{
		if (index == arr.length)
			return;



		if (arr[index].isFile())
			System.out.println(arr[index].getName());

		Direct (arr, ++index);
	}
	//File retrieve End Here. 

	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int option;
		int suboption;
		System.out.println("****************************************************");
		System.out.println("*** Application Developed by Ansari Wasim Shamim ***");
		System.out.println("***        Under Company Locker Pvt. Ltd         ***");
		System.out.println("***          File Handling Application           ***");
		System.out.println("****************************************************");
		System.out.println();


		do
		{
			System.out.println();
			System.out.println("        WELCOME TO FILE HANDLING APP       ");
			System.out.println();
			System.out.println("Select Menu for Operation   ");
			System.out.println("=========================");
			System.out.println();
			System.out.println("1 - Option to Display the Current Directory Files");
			System.out.println("2 - Options for Modification to Directory");
			System.out.println("3 - Exit");
			option=sc.nextInt();
			switch(option) {

			case 1:// Code to display current Directory
				System.out.println("Option to Display File");

				// Provide full path for directory(change
				// accordingly)
				String maindirpath= "F://New folder";

				File maindir = new File(maindirpath);



				if (maindir.exists() && maindir.isDirectory()) {

					File arr[] = maindir.listFiles();

					System.out.println(
							"**********************************************");
					System.out.println(
							"Files from main directory : " + maindir);
					System.out.println(
							"**********************************************");
					Direct (arr, 0);
				}

				else{
					System.out.println("Directory does not exist");
				}

				break;





			case 2: //Options for Modification in Directory

				System.out.println("Modification Of Directory File");
				System.out.println("Choose the operation to do...");
				System.out.println("11 - Add File");
				System.out.println("12 - Delete File");
				System.out.println("13 - Search File");
				System.out.println("14 - Back to Main Menu");
				suboption=sc.nextInt();
				switch(suboption)
				{


				case 11:
					// Option to Add File to Directory
					System.out.println("Add Files");
					String strPath = "", strName = "";

					try {
						BufferedReader br = new BufferedReader(
								new InputStreamReader(System.in));

						System.out.println("Enter the file name:");
						// Reading File name
						strName = br.readLine();

						System.out.println("Enter the file path:");
						// Reading File Path
						strPath = br.readLine();

						// Creating File Object
						File file1
						= new File(strPath + "" + strName + ".txt");
						file1.createNewFile();
						System.out.println("New File has been created:" +strPath+""+strName);
					}

					catch (Exception ex1) {
					}

					break;


				case 12:
					// Option to Delete from Directory
					System.out.println("Delete Files");
					String strPath1 = "", strName1 = "";

					try {

						BufferedReader br = new BufferedReader(
								new InputStreamReader(System.in));

						System.out.println("Enter the file name:");
						// Reading File name
						strName1 = br.readLine();

						System.out.println("Enter the file path:");
						// Reading File Path
						strPath1 = br.readLine();

						File file1
						= new File(strPath1 + "" + strName1 + ".txt");
						if(file1.exists()) {
							file1.delete();
							System.out.println("File " +strPath1+""+strName1+ " has been deleted.");
						}
						else {
							System.out.println("File does not Exist");
						}
					}

					catch (Exception ex1) {
					}

					break;		


				case 13:
					//Option to Search from Directory
					System.out.println("Search Files");
					Scanner obj = new Scanner(System.in);
					String file1;
					System.out.println("Enter the file name to be Searched with extension");
					System.out.println("Case Sensitive Text");
					file1 = obj.nextLine();
					File directory = new File("F:/New folder/");
					String[] flist = directory.list();
					int flag1 = 0;
					if (flist == null) {
						System.out.println("Empty directory.");
					}
					else {

						// Linear search in the array
						for (int i = 0; i < flist.length; i++) {
							String filename = flist[i];
							if (filename.equals(file1)) {
								System.out.println(filename + " found");
								flag1 = 1;
							}
						}
					}

					if (flag1 == 0) {
						System.out.println("File Not Found");
					}

					break;


				case 14:

					System.out.println("Return to Main Menu");

					break;
				}
			}
		}
		while (true);
	}






}




