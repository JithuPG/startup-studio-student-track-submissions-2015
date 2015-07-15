%PROGRAM FOR SIMILARITY OF TWO IMAGES USING URL OF IMAGES
clc;
clear all;
close all;
x=input('ENTER THE URL 1:','s');
i1=imread(x);
y=input('ENTER THE URL 2:','s');
i2=imread(y);
subplot(1,2,1);imshow(i1);title('IMAGE 1');
subplot(1,2,2);imshow(i2);title('IMAGE 2');
imwrite(i1,'s.tif');
imwrite(i2,'n.tif');
i1=imresize(i1,[300 300]);
i2=imresize(i2,[300 300]);
i1=rgb2gray(i1);
i2=rgb2gray(i2);
[ssimval,ssimmap]=ssim(i1,i2);
p=ssimval*100;
fprintf('THE SSIM VALUE :%0.4f\n',ssimval);
figure,imshow(ssimmap,[]);
title(sprintf('SSIM INDEX MAP\n MEAN SSIM VALUE IS %0.4f\n SIMILARITY PERCENTAGE:%0.2f',ssimval,p));
if(ssimval<=0.0099999)
    disp('VERY DIFFERENT IMAGES');
else if(ssimval==1)
        disp('TWO IMAGES ARE 100% SIMILAR');
    else
        fprintf('TWO IMAGES ARE %0.2f',p);
        disp('% similar');
    end
end
