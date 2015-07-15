clc
close all
clear all


a=imread('image1.jpg');
d=size(a);
d=size(d);
if d(1,2)==3
    a=rgb2gray(a) ;
 
end
 a=imresize(a,[255 255]);
 %a=a./max(max((abs(a)))); 


b=imread('image2.jpg');

d=size(b);
d=size(d);
if d(1,2)==3
    b=rgb2gray(b) ;
    
end
h=rand(255)*100;

b=imresize(b,[255 255]);
%b=b./max(max((abs(b))));
[nn mm]= size(b);


n1=sum(sum(a.^2))/(nn*mm)*100;
n2=sum(sum(b.^2))/(nn*mm)*100;
mes=abs(n1-n2);
mes


