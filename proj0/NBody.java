public class NBody{
    private static int N;//the number of planets.
    private static double R;//the radius of the universe

    // Given a file name as a String, it should return a double corresponding to the radius of the universe in that file
    public static double readRadius(String file){
        In in=new In(file);
        N=in.readInt();
        R=in.readDouble();
        return R;
    }

    //  Given a file name, it should return an array of Planets corresponding to the bodies in the file
    public static Planet[] readPlanets(String file){
        In in=new In(file);
        N=in.readInt();
        in.readDouble();
        Planet[] b1=new Planet[N];
        for(int i=0;i<N;i++){
            double xP=in.readDouble();
            double yP=in.readDouble();
            double xV=in.readDouble();
            double yV=in.readDouble();
            double m=in.readDouble();
            String img=in.readString();
            Planet b2=new Planet(xP,yP,xV,yV,m,img);
            b1[i]=new Planet(b2);
        }
        return b1;
    }

    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);

        String path="images/starfield.jpg";
        String filename=args[2];
        R=NBody.readRadius(filename);
        Planet[] b=NBody.readPlanets(filename);
        
        //Creating an Animation
        for(double t=0;t<T;t++){
            double[] xForces=new double[N];
            double[] yForces=new double[N];
            for(int j=0;j<N;j++){
                xForces[j]=b[j].calcNetForceExertedByX(b);
                yForces[j]=b[j].calcNetForceExertedByY(b);
            }
            for(int k=0;k<N;k++){
                b[k].update(dt,xForces[k],yForces[k]);
            }
            
            StdDraw.clear();
            StdDraw.enableDoubleBuffering();
            StdDraw.setScale(-R,R);

            StdDraw.enableDoubleBuffering();
            StdDraw.setScale(-R,R);
            StdDraw.picture(0,0,path);
            //Drawing More than One Planet
            for(int i=0;i<N;i++){
                b[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        //Printing the Universe
        StdOut.printf("%d\n",N);
        StdOut.printf("%.2e\n",R);
        for(int i=0;i<N;i++){
            System.out.printf("%11.4e,%11.4e,%11.4e,%11.4e,%11.4e,%12s\n",
                  b[i].xxPos, b[i].yyPos, b[i].xxVel,
                  b[i].yyVel, b[i].mass, b[i].imgFileName);
        }
    }
}
