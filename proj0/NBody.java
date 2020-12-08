class NBody{
	/** This class is only for simluation. Therefore there is no constructor */
	public static double readRadius(String fileName){
		/** read radius from the given file. The first line of file is int type N, and the double type radius is in the second line */
		In in = new In(fileName);
		in.readInt();
		return in.readDouble();
	}

	public static Body[] readBodies(String fileName){
		/** read all bodies from the given file. 
		 *  The first line of file is int type N (number of bodies in the file), and the double type radius is in the second line,
		 *  The contained bodies are in the rest of the lines with formate: x-Pos, y-Pos, x-Vel, y-Vel, mass, imagePath.*/
                In in = new In(fileName);
                int N = in.readInt();
		in.readDouble(); // skip radius
		Body[] bodies = new Body[N]; // create an array with N number of bodies in it.
		for(int i =0; i < N; i++){
			bodies[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		}
		return bodies;
	}

	public static void main(String[] args){
		/** In this function, an animation is gernerated based on the parameter provided within three steps.
		 * (1) Collecting and store all the needed information from arguments(total time, time step and file name),
		 * body information from specified file. 
		 *  - collect all needed information from the given file
		 *  - Store the 0th and 1st command line arguments as double T and dt
		 *  - Store the 2nd command line argument as a String named filename.
		 *  - read in all bodies and universe radius by the method defined earlier. 
		 * 
		 * (2)Draw the initial state of universe
		 * */
		
		/* (1) Collecting and Store information */
		if (args.length == 0) {
			System.out.println("Please supply a country as a command line argument.");
			System.out.println("For countries with spaces, use an underscore, e.g. South_Korea");
			return;
		}
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Body[] bodies = readBodies(filename);
		int N = bodies.length;	

		/* (2) Draw the inital state of universe */
		/** Enables double buffering.
		  * A animation technique where all drawing takes place on the offscreen canvas.
		  * Only when you call show() does your drawing get copied from the
		  * offscreen canvas to the onscreen canvas, where it is displayed
		  * in the standard drawing window. */
		StdDraw.enableDoubleBuffering();
		
		/** Sets up the universe so it goes from
		  * -radius, -radius up to radius, radius */
		double leftLowest = -1 * radius;
		double rightHighest = radius;
		StdDraw.setScale(leftLowest, rightHighest);
		
		/* Clears the drawing window. */
		StdDraw.clear();
		
		/* Draw the background with the central at (x,y) */
		StdDraw.picture(0, 0, "images/starfield.jpg");
		
		/* Call the draw method from each body */
		for(Body body: bodies)
			body.draw();

		/* show the screen */
		StdDraw.show();

		/* (3) Generate the animation according to the given time and time step */
		double[] xForces = new double[N];
		double[] yForces = new double[N];

		for(double t = 0; t<T; t+=dt){
			StdDraw.clear();
			
			/* calculate the net force is exerted on each body in x and y dimension respectivily*/
			for (int i = 0; i < N; i++){
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}
			
			/* update position of each body according to the net forces */
			for (int i =0; i < N; i++)
				bodies[i].update(dt, xForces[i], yForces[i]);
			
			/* Draw the background */
			StdDraw.picture(0, 0, "images/starfield.jpg");
			
			for(Body body: bodies)
				body.draw();
			StdDraw.show();
			StdDraw.pause(10);
		}
	        StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
    			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  	bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  	bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}	

	}
}
