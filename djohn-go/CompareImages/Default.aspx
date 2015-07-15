<%@ Page Language="C#" AutoEventWireup="true"  CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Untitled Page</title>
    <style type="text/css">
        .style1
        {
            width: 105%;
            height: 245px;
        }
        .style2
        {
            font-weight: normal;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server" enctype="multipart/form-data">
    <div>
    
        <asp:Panel ID="Panel1" runat="server" Font-Bold="True" 
            GroupingText="COMPARING IMAGES IN ASP.NET" Height="132px" Width="440px">
            <table class="style1">
                <tr>
                    <td class="style2">
                        SELECT IMAGE ONE</td>
                    <td>
                        <asp:FileUpload ID="FileUpload1" runat="server" />
                    </td>
                    <td>
                        <asp:Image ID="Image1" runat="server" />
                    </td>
                </tr>
                <tr>
                    <td class="style2">
                        SELECT IMAGE TWO</td>
                    <td>
                        <asp:FileUpload ID="FileUpload2" runat="server" />
                    </td>
                </tr>
                <tr>
                    <td class="style2">
                        &nbsp;</td>
                    <td>
                        <asp:Button ID="btncompare" runat="server" Font-Bold="True" 
                            onclick="btncompare_Click" Text="Compare" />
                    </td>
                </tr>
                <tr>
                    <td class="style2">
                        <asp:Label ID="Label1" runat="server" Text="Label" Visible="False" 
                            style="font-weight: 700"></asp:Label>
                    </td>
                    <td>
                        <asp:Label ID="Label2" runat="server" Text="Label" Visible="False"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="style2">
                        <asp:Label ID="Label3" runat="server" style="font-weight: 700" Text="Label" 
                            Visible="False"></asp:Label>
                    </td>
                    <td>
                        <asp:Label ID="Label4" runat="server" style="font-weight: 700" Text="Label" 
                            Visible="False"></asp:Label>
                    </td>
                </tr>
            </table>
        </asp:Panel>
    
    </div>
    </form>
    <p>
        &nbsp;</p>
</body>
</html>
