public class Body{
	public double xxPos;	//Its current x position
	public double yyPos;	//Its current y position
	public double xxVel;	//Its current velocity in the x direction
	public double yyVel;	//Its current velocity in the y direction
	public double mass;	//Its mass 
	public String imgFileName; //The name of the file that corresponds to the image that depicts the body(e.g. jupiter.gif)
	
	public Body(double xP, double yP, double xV, 
			double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	
	public Body(Body b){
	        xxPos = b.xxPos;
                yyPos = b.yyPos;
                xxVel = b.xxVel;
                yyVel = b.yyVel;
                mass = b.mass;
                imgFileName = b.imgFileName;	
	}
	
	public double calcDistance(Body source){
		/** calculate the distance from this body to the given source */
		return Math.sqrt(Math.pow(xxPos - source.xxPos, 2) + Math.pow(yyPos - source.yyPos, 2));
	}

	public double calcForceExertedBy(Body source){
		/** calculate the total force due to the gravity from the given source based on Newton's first law */
		if (this.equals(source))
			return 0;
		return (6.67e-11 * mass * source.mass) / Math.pow(this.calcDistance(source), 2);
	}

	public double calcForceExertedByX(Body source){
		/** calculate the gravity force due to the given source in the x-dimension */ 
		if (this.equals(source))
			return 0;
		return this.calcForceExertedBy(source) * (source.xxPos - xxPos) / calcDistance(source);  
	}

        public double calcForceExertedByY(Body source){
		 /** calculate the gravity force due to the given source in the y-dimension */
                if (this.equals(source))
                        return 0;
                return this.calcForceExertedBy(source) * (source.yyPos - yyPos) / calcDistance(source);
        }

	public double calcNetForceExertedByX(Body[] sources){
		/** calculate the net force due to all of the given sources in the x-dimension */
		double NF = 0;
		for(Body source: sources){
			if(this.equals(source))
				continue;
			NF += this.calcForceExertedByX(source);
		}
		return NF;
	}

        public double calcNetForceExertedByY(Body[] sources){
		 /** calculate the net force due to all of the given sources in the y-dimension */
                double NF = 0;
                for(Body source: sources){
                        if(this.equals(source))
                                continue;
                        NF += this.calcForceExertedByY(source);
                }
                return NF;
        }
	
	public void update(double dt, double fX, double fY){
		/** update the position and velocity according to the given time step and forces in x and y dimension. */
		xxVel = xxVel + fX / mass * dt; //new velocity = old velocity + acceleration * dt 
		yyVel = yyVel + fY / mass * dt;
		xxPos = xxPos + xxVel * dt; // new position = old position + new velocity * dt;
		yyPos = yyPos + yyVel * dt;
	}

	public void draw(){
		/** Draw this body at the screen with the given image according to its x and y position,
		 *  Becasue image are stored in the dictory "images", an prefix have to added for drawing the picture*/
		StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
	}
}
