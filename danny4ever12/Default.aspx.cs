using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using CloudinaryDotNet;
using CloudinaryDotNet.Actions;

public partial class _Default : System.Web.UI.Page
{
    string phash1 = "", phash2 = "", sim_scale = "", sim_comment = "";

    //returning comment and similarity scale value 
    public string sn1 { get { return sim_comment; } }
    public string sn2 { get { return sim_scale; } }
  
    //on page load
     protected void Page_Load(object sender, EventArgs e)
    {
       

    }

    //on button click
    protected void Button1_Click(object sender, EventArgs e)
    {
       //setting cloudinary account
        Account account = new Account(
        "dfd9kesq3",
        "263446946632429",
        "3CK5mZyoZMbfhigPIKNO4LLVg2c");
       
        try
        {
            //for displaying the image provided by user
            Image1.ImageUrl = TextBox1.Text;
            Image2.ImageUrl = TextBox2.Text;

            Cloudinary cloudinary = new Cloudinary(account);

            //for uploading image to cloudinary server
            var uploadParams1 = new ImageUploadParams()
            {
                File = new FileDescription(@TextBox1.Text),
                Phash = true
            };
            var uploadResult1 = cloudinary.Upload(uploadParams1);

            var uploadParams2 = new ImageUploadParams()
            {
                File = new FileDescription(@TextBox2.Text),
                Phash = true
            };
            var uploadResult2 = cloudinary.Upload(uploadParams2);
            
            //retriving phash values
            phash1 = uploadResult1.Phash;
            phash2 = uploadResult2.Phash;

            //for calculating similarity scale
            int phash_distance = calcXor(phash1, phash2);
            float temp = (float)phash_distance;
            float similarity_value = (1 - (temp / 128))*100;
            sim_scale = "similarity scale: " + similarity_value.ToString() + " / 100";

            //for similarity comment
            if (similarity_value == 100)
            {
                sim_comment = "exactly same image";
            }
            else if (similarity_value >= 90)
            {
                sim_comment = "almost same image";
            }
            else if (similarity_value >= 75)
            {
                sim_comment = "slightly similar image";
            }
            else
            {
                sim_comment = "two different images";
            }

        }
        catch (Exception k)
        {
            Response.Write("<script>alert('error: "+ Server.HtmlEncode(k.Message) + "')</script>");
        }
       
       
    }

    //for comparing two phash values
    public int calcXor(string str1,string str2)
    {
        //for the bitcount of no:of 1's
        int count = 0;
        
            //converting str1 to byte array
            byte[] byt_string1 = System.Text.Encoding.UTF8.GetBytes(str1);


            //converting byte array to bits
            BitArray bit_string1 = new BitArray(byt_string1);

            //converting str2 to byte array
            byte[] byt_string2 = System.Text.Encoding.UTF8.GetBytes(str2);


            //converting byte array to bits
            BitArray bit_string2 = new BitArray(byt_string2);

            //checking for equal size of bit array
            if (bit_string1.Length == bit_string2.Length)
            {
                bit_string1.Xor(bit_string2);
            }

            else
            {
                bit_string2.Length = bit_string1.Length;
                bit_string1.Xor(bit_string2);
            }

       
        for (int i = 0; i < bit_string1.Length; i++)
        {
        
            
         //   counting number of 1's in bit_string1[]
            if (bit_string1[i].Equals(true))
            {
                ++count;
            }
        }
        
        return count;
    
        
    }

   

    
    
}