<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ Import Namespace="CloudinaryDotNet" %>
<%@ Import Namespace="CloudinaryDotNet.Actions" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Image | Comparison</title>

    
</head>
<body style="background-image: url('images/mainback.jpg'); width:100%; height:50%; margin-left: 8px;">

    <form id="form1" runat="server">
       <div>
            <h1 style="color: #6D0770; font-family: Arial, Helvetica, sans-serif; font-size: 45px; font-style:normal; z-index: 1; left: 11px; top: 20px; height: 56px; width: 1356px; font-weight: bold;" 
              align="center">Compare two images</h1> 
       </div>
       <div>
            <p style="color: #6D0770; font-family: Calibri; font-size: xx-large; font-style: italic; z-index: 1; left: 11px; top: 20px; height: 28px; width: 400px; font-weight: bold; font-variant: normal;" 
            align="left">Enter links of images here</p>    
       </div>
       <div>
            <p style="color: #6D0770; font-family: Calibri; font-size: medium; font-style: italic; z-index: 1; left: 11px; top: 20px; height: 28px; width: 400px; font-weight: bold; font-variant: normal;" 
            align="left">image1</p> 
       </div>
       <div>
            <asp:TextBox ID="TextBox1" runat="server" BackColor="#D7D7D7" 
            BorderColor="#9966FF" BorderStyle="Groove" ForeColor="#666666" Height="34px" 
            Width="343px"></asp:TextBox>
       </div>
       <div>
            <p style="color: #6D0770; font-family: Calibri; font-size: medium; font-style: italic; z-index: 1; left: 11px; top: 20px; height: 28px; width: 400px; font-weight: bold; font-variant: normal;" 
            align="left">image2</p>   
       </div>
       <div>
            <asp:TextBox ID="TextBox2" runat="server" BackColor="#D7D7D7" 
            BorderColor="#9966FF" BorderStyle="Groove" ForeColor="#666666" Height="34px" 
            Width="343px"></asp:TextBox>
       </div>
    
       <p style="width: 91px; height: 4px"></p>
   
       <div style="width: 337px; height: 71px">
            <asp:Button ID="Button1" runat="server" 
             onclick="Button1_Click" Text="done" Font-Bold="True" Font-Italic="True" 
             Font-Size="X-Large" ForeColor="White" 
             ToolTip="click here after two links are provided" Width="189px" 
             BackColor="#6666FF" BorderColor="#3399FF" BorderStyle="Groove" />
       </div> 
    
       <div style="position:absolute; top: 185px; left: 455px; height: 136px; width: 262px;"> <asp:Image ID="Image1" runat="server"  Height="136px" Width="262px" /></div>
       <div style="position:absolute; top: 185px; left: 740px; height: 136px; width: 262px;"> <asp:Image ID="Image2" runat="server"  Height="136px" Width="262px" /></div>
    
     
       <div style="position:absolute; top: 336px; left: 455px; height: 29px; width: 547px;">
             <p style="color: #800080; font-family: Calibri; font-size: x-large; font-style: italic; font-weight: normal; font-variant: normal;" align="left"> <%=sn1%></p> 
       </div>
        
       <div style="position:absolute; top: 380px; left: 455px; height: 29px; width: 547px;">
             <p style="color: #800080; font-family: Calibri; font-size: x-large; font-style: italic; font-weight: normal; font-variant: normal;"  align="left"> <%=sn2%></p>
       </div>
    </form>
    
  </body>
</html>
