using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net;

namespace WindowsFormsApplication6
{
    public partial class Form1 : Form
    {
        Bitmap image1 = null;
        Bitmap image2 = null;
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            /*OpenFileDialog openDialog = new OpenFileDialog();
            if (openDialog.ShowDialog() == DialogResult.OK)
            {
                image1 = new Bitmap(openDialog.FileName);
                pictureBox1.Image = image1;
            }*/

            string url1 = textBox1.Text;
            pictureBox1.ImageLocation = url1;
            /*var request = WebRequest.Create(url1);

            using (var response = request.GetResponse())
            using (var stream = response.GetResponseStream())
            {
                pictureBox1.Image = Bitmap.FromStream(stream);
                image1 = (Bitmap)Bitmap.FromStream(stream);
            }*/
        }

        private void button2_Click(object sender, EventArgs e)
        {

            /*OpenFileDialog openDialog = new OpenFileDialog();
            if (openDialog.ShowDialog() == DialogResult.OK)
            {
                image2 = new Bitmap(openDialog.FileName);
                pictureBox2.Image = image2;
            }  */
            string url2 = textBox2.Text;
            pictureBox2.ImageLocation = url2;
            
            /*var request = WebRequest.Create("https://upload.wikimedia.org/math/2/3/d/23d64887f9c2add7a296e5b99acbbdfb.png");

            using (var response = request.GetResponse())
            using (var stream = response.GetResponseStream())
            {
                pictureBox2.Image = Bitmap.FromStream(stream);
                image2 = (Bitmap)Bitmap.FromStream(stream);
                
            }*/
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Bitmap bmp1 = (Bitmap)pictureBox1.Image;
            Bitmap bmp2 = (Bitmap)pictureBox2.Image;
            if (compare(bmp1, bmp2))
            {
                MessageBox.Show("Same Image.");
            }

            else
            {
                MessageBox.Show("Different Image.");
            }
        }
        private bool compare(Bitmap bmp1, Bitmap bmp2)
        {
            bool equals = true;
            bool flag = true;  //Inner loop isn't broken
            
            //Test to see if we have the same size of image
            if (bmp1.Size == bmp2.Size)
            {
                for (int x = 0; x < bmp1.Width; ++x)
                {
                    for (int y = 0; y < bmp1.Height; ++y)
                    {
                        if (bmp1.GetPixel(x, y) != bmp2.GetPixel(x, y))
                        {
                            equals = false;

                            flag = false;
                            break;
                        }
                    }
                    if (!flag)
                    {
                        break;
                    }
                }
            }
            else
            {
                equals = false;
            }
            return equals;
        }
    }
}
