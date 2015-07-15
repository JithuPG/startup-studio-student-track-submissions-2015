public class NaiveSimilarityFinder
{
	
	final static int threshold=600;
   
    int f = 0,f1=0;
    String filepath, filename, path, savePath,cname;
    private static double[][][] signature;
    private static final int baseSize = 300;
    public static int flag=0;
    public static String SimilarityFinder(Bitmap ref, android.content.ContentResolver contentResolver)
    {
    	 String b = "-1";      
	try {
	  ref = rescale(ref);	
        signature = calcSignature(ref);
        File[] others = getOtherImageFiles();
        Bitmap[] rothers = new Bitmap[others.length];
        double[] distances = new double[others.length];
        for (int o = 0; o < others.length; o++) 
        {
            try {
rothers[o] = rescale(Media.getBitmap(contentResolver,                  Uri.fromFile(others[o]) ) );
			}
 catch (IOException e) {
				e.printStackTrace();
                       distances[o] = calcDistance(rothers[o]);
      		  }

        b=distances.length+" :: "+b;
        Bitmap tempR;
        for (int p1 = 0; p1 < others.length - 1; p1++) 
        {
            for (int p2 = p1 + 1; p2 < others.length; p2++) 
            {
                if (distances[p1] > distances[p2]) 
                {
                    double tempDist = distances[p1];
                    distances[p1] = distances[p2];
                    distances[p2] = tempDist;
                    tempR = rothers[p1];
                    rothers[p1] = rothers[p2];
                    rothers[p2] = tempR;
                    File tempF = others[p1];
                    others[p1] = others[p2];
                    others[p2] = tempF;
                }
            }
        }       
       int o;
        for (o = 0; o < others.length; o++) 
        {
        	 b = b+" "+ distances[o];    
           
            if (distances[o] < threshold)
            {
                    
                    b = "WIN "+ distances[o];                    
                    break;
            }
        }
       
        
		} catch (Exception e) {
			e.printStackTrace();
		}
     return b;
        
        
      }    
private static Bitmap rescale(Bitmap image)
{
	int width = image.getWidth();
	int height = image.getHeight();
	float scaleWidth = ((float) baseSize) / width;
	float scaleHeight = ((float) baseSize) / height;
	Matrix matrix = new Matrix();
	matrix.postScale(scaleWidth, scaleHeight);
	Bitmap resizedBitmap = Bitmap.createBitmap(image, 0, 0, width, height, matrix, false);

	return resizedBitmap;

	
}

    private static double[][][] calcSignature(Bitmap i)
    {
        double[][][] sig = new double[5][5][3];
        float[] prop = new float[]{1f / 10f, 3f / 10f, 5f / 10f, 7f / 10f, 9f / 10f};
        for (int x = 0; x < 5; x++)
        {
            for (int y = 0; y < 5; y++)
            {
                sig[x][y] = averageAround(i, prop[x], prop[y]);
            }
        }
        return sig;
    }  
    private static double[] averageAround(Bitmap i, double px, double py) 
    {
        double[] pixel = new double[3];
        double[] accum = new double[3];
        int sampleSize = 15;
        for (double x = px * baseSize - sampleSize; x < px * baseSize + sampleSize; x++) 
        {
            for (double y = py * baseSize - sampleSize; y < py * baseSize + sampleSize; y++)
            {
                pixel=getRGB(i,(int) x,(int) y) ;
                accum[0] += pixel[0];
                accum[1] += pixel[1];
                accum[2] += pixel[2];
            }
        }
        accum[0] /= sampleSize * sampleSize * 4;
        accum[1] /= sampleSize * sampleSize * 4;
        accum[2] /= sampleSize * sampleSize * 4;
        return accum;
    }
  
    static double[] getRGB(Bitmap bitmap,int x,int y){
    	double[] rgb=new double[3];
    	
    	int pix = bitmap.getPixel(x,y);
    	
           rgb[0]  = (pix >> 16) & 0xff;     
           rgb[1]  = (pix >> 8) & 0xff;     
           rgb[2]  = (pix ) & 0xff;     
            
    	return rgb;
    }
    
    private static double calcDistance(Bitmap other)
    {
        double[][][] sigOther = calcSignature(other);
                double dist = 0;
        for (int x = 0; x < 5; x++)
        {
            for (int y = 0; y < 5; y++) 
            {
                int r1 = (int)signature[x][y][0];
                int g1 = (int)signature[x][y][1];
                int b1 = (int)signature[x][y][2];
                int r2 =(int) sigOther[x][y][0];
                int g2 =(int) sigOther[x][y][1];
                int b2 = (int)sigOther[x][y][2];
                double tempDist = Math.sqrt((r1 - r2) * (r1 - r2) + (g1 - g2) * (g1 - g2) + (b1 - b2) * (b1 - b2));
                dist += tempDist;
            }
        }
        return dist;
    }
  private static File[] getOtherImageFiles()
    {
	  String location=SaveImageTask.dir.toString();
	  
		File dir = new File(location);
        File[] others = dir.listFiles();
        
        return others;
    }
    		
		
protected void onCreate(Bundle savedInstanceState) 
	{
				super.onCreate(savedInstanceState);
		setContentView(R.layout.page3);
		t1=(TextView) findViewById(R.id.textV2);
		Button b1=(Button) findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				sa="";
				Intent a=new Intent(getApplicationContext(),cammm.class);
				SignUp.number=3;
				startActivityForResult(a, 1337);
			}
		}
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{

		     	ContentResolver contentResolver=getContentResolver();
		    	if(captureBmp!=null)
		    	{
		    		 sa=NaiveSimilarityFinder.SimilarityFinder(captureBmp,contentResolver).trim();
		    		 if(sa.startsWith("WIN "))
		    		 {
		    			Toast.makeText(getApplicationContext(), "MATCHING", Toast.LENGTH_SHORT).show();
		    			
		    		 }
		    		 else				
		    		 {
		    			i--;
		    			t1.setText(String.valueOf(i));
		    			Toast.makeText(getApplicationContext(), "Not Matching ", Toast.LENGTH_SHORT).show();
		    			
		    		}
		    	}
   }
		
		
	
		
		}
