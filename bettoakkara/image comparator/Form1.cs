using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Diagnostics;
using System.IO;
using System.Net;
using System.Text.RegularExpressions;



namespace image_comparator
{
    public partial class Form1 : Form
    {
    
        public Form1()
        {
            InitializeComponent();
        }

        static string fname1, fname2;
        Bitmap img1, img2;
        int count1 = 0, count2 = 0;
        bool flag = true;

       
        private void image1_Click(object sender, EventArgs e)
        {
    
            string url = textBox1.Text;

            var request = WebRequest.Create(url);
            using (var response = request.GetResponse())
            using (var stream = response.GetResponseStream())
            {
                pictureBox1.Image = Bitmap.FromStream(stream);
            }
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
         
        }

        private void image2_Click(object sender, EventArgs e)
        {

            string url = textBox2.Text;

            var request = WebRequest.Create(url);
            using (var response = request.GetResponse())
            using (var stream = response.GetResponseStream())
            {
                pictureBox2.Image = Bitmap.FromStream(stream);
            }
            pictureBox2.SizeMode = PictureBoxSizeMode.StretchImage;
            
        }

        private void compare_Click(object sender, EventArgs e)
        {
         



            progressBar1.Visible = true;

            string img1_ref, img2_ref;
            img1 = new Bitmap(pictureBox1.Image);
            img2 = new Bitmap(pictureBox2.Image);

            progressBar1.Maximum = img1.Width;
            if (img1.Width == img2.Width && img1.Height == img2.Height)
            {
                for (int i = 0; i < img1.Width; i++)
                {
                    for (int j = 0; j < img1.Height; j++)
                    {
                        img1_ref = img1.GetPixel(i, j).ToString();
                        img2_ref = img2.GetPixel(i, j).ToString();
                        if (img1_ref != img2_ref)
                        {
                            count2++;
                            flag = false;
                            break;
                        }
                        count1++;
                    }
                    progressBar1.Value++;
                }

                if (flag == false)
                {
                   label3.Text="Sorry, Images are not same , " + count2 + " wrong pixels found";
                    
                }
                else
                {
                   label3.Text=" Images are same , " + count1 + " same pixels found  and " + count2 + " wrong pixels found";
                 
                }
            }
            else
                 label3.Text="can not compare this images";
       

            
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {
            
        }
        

       

    }
}
