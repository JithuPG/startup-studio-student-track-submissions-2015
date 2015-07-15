using System;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
//using System.Web.UI.WebControls;
//using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;
using System.Drawing;
using System.Security.Cryptography;
using System.ComponentModel;
using System.IO;
using System.Drawing.Imaging; 
public partial class _Default : System.Web.UI.Page
{
    //Byte Array Declaration
    byte[] _barray1;
    byte[] _barray2;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {

        }
    }
    protected void btncompare_Click(object sender, EventArgs e)
    {
        try
        {
            //Reading Bytes From Uploaded Images

            if (FileUpload1.HasFile && FileUpload2.HasFile)
            {
                using (BinaryReader reader1 = new BinaryReader(FileUpload1.PostedFile.InputStream))
                {
                    using (BinaryReader reader2 = new BinaryReader(FileUpload2.PostedFile.InputStream))
                    {
                        _barray1 = reader1.ReadBytes(FileUpload1.PostedFile.ContentLength);
                        _barray2 = reader2.ReadBytes(FileUpload2.PostedFile.ContentLength);
                    }
                }
            }
            //Converting Byte Array To Image And Then Into Bitmap
            ImageConverter ic = new ImageConverter();
            Image img = (Image)ic.ConvertFrom(_barray1);
            Bitmap bmp1 = new Bitmap(img);
            
            Image img1 = (Image)ic.ConvertFrom(_barray2);
            Bitmap bmp2 = new Bitmap(img1);

            //Calling Compare Function

            if (Class1.Compare(bmp1, bmp2) == Class1.CompareResult.ciCompareOk)
            {
                Label1.Visible = true;
                Label1.Text = "Images Are Same";
            }
           if (Class1.Compare(bmp1, bmp2) == Class1.CompareResult.ciPixelMismatch)
            {
                Label2.Visible = true;
                Label2.Text = "Pixel not Matching";
            }
            if (Class1.Compare(bmp1, bmp2) == Class1.CompareResult.ciSizeMismatch)
            {
                Label3.Visible = true;
                Label3.Text = "Size is not Same";
            }
            if (Class1.Compare(bmp1, bmp2) != Class1.CompareResult.ciCompareOk)
            {
                Label1.Visible=true;
                Label1.Text = "images are not same";
            }

            if (Class1.Compare(bmp1, bmp2) != Class1.CompareResult.ciPixelMismatch )
            {
                Label2.Visible = true;
                Label2.Text = "Pixel Matching";
            }
            if (Class1.Compare(bmp1, bmp2) != Class1.CompareResult.ciSizeMismatch)
            {
                Label3.Visible = true;
                Label3.Text = "Size is Same";
            }


        }
        catch (Exception ex)
        {
            Label1.Visible = true;
            Label1.Text = ex.Message.ToString();
        }
    }
    
}