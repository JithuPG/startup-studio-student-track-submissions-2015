using System;
using XnaFan.ImageComparison;


namespace ConsoleComparison
{

    /// <summary>
    /// Console program which compares two iages and returns the difference in percentage as an errorlevel between zero and a hundred (both included).
    /// </summary>
    class Program
    {
        static int Main(string[] args)
        {
            if (args.Length != 2)
            {
                return -1;
            }
            else
            {
                //get, display and return the difference
                int difference1 = (int)(ImageTool.GetPercentageDifference(args[0], args[1])*100);
                Console.WriteLine("Similarity is {0}%", 100-difference1);
                return difference1;
            }
        }
    }
}