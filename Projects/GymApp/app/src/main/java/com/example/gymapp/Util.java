package com.example.gymapp;

import android.util.Log;

import java.util.ArrayList;

public class Util {
    private static final String TAG = "Util";

    private static ArrayList<GymTraining> allTrainings;

    private static ArrayList<Plan> UserPlans;

    public Util() {
    }

    public static void initAll()
    {
        Log.d(TAG, "initAll: Called");

        if(null == allTrainings)
            allTrainings = new ArrayList<>();

        if(null == UserPlans)
            UserPlans = new ArrayList<>();

        GymTraining squat = new GymTraining();
        squat.setName("Squat");
        squat.setShortDesc("A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up");
        squat.setLongDesc("Squats are considered a vital exercise for increasing the strength and size of the lower body muscles as well as developing core strength. The primary agonist muscles used during the squat are the quadriceps femoris, the adductor magnus, and the gluteus maximus.[1] The squat also isometrically uses the erector spinae and the abdominal muscles, among others.[2]\n" +
                "\n" +
                "The squat is one of the three lifts in the strength sport of powerlifting, together with the deadlift and the bench press. It is also considered a staple exercise in many popular recreational exercise programs.");
        squat.setImageUrl("https://lmimirror3pvr.azureedge.net/static/media/14850/b370e65a-5c02-4379-b38a-29ab5977f59f/ar_55-brief-3-gallery-960x540.jpg");
        allTrainings.add(squat);

        GymTraining pushup = new GymTraining();
        pushup.setName("Push-up");
        pushup.setShortDesc("A push-up (or press-up if the hands are wider than shoulders placing more emphasis on the pectoral muscles");
        pushup.setLongDesc("By raising and lowering the body using the arms, push-ups exercise the pectoral muscles, triceps, and anterior deltoids, with ancillary benefits to the rest of the deltoids, serratus anterior, coracobrachialis and the midsection as a whole. Push-ups are a basic exercise used in civilian athletic training or physical education and commonly in military physical training. They are also a common form of punishment used in the military, school sport, or some martial arts disciplines.");
        pushup.setImageUrl("https://s1.thcdn.com/static-sites/askfitnesscoach/wp-content/uploads/man-doing-push-ups-at-gym.jpg");
        allTrainings.add(pushup);

        GymTraining chestfly = new GymTraining();
        chestfly.setName("Chest fly");
        chestfly.setShortDesc("A fly or flye is a strength training exercise in which the hand and arm move through an arc while the elbow is kept at a constant angle.");
        chestfly.setLongDesc("Flies are used to work the muscles of the upper body. Because these exercises use the arms as levers at their longest possible length, the amount of weight that can be moved is significantly less than equivalent press exercises for the same muscles (the military press and bench press for the shoulder and chest respectively).[1] Due to this leverage, fly exercises of all types have a large potential to damage the shoulder joint and its associated ligaments and the tendons of the muscles connecting to it. They should be done with caution and their effects first tested while using very light weights; which are gradually incremented after more strength is gained.");
        chestfly.setImageUrl("https://images.myupchar.com/9661/chest-fly-exercise.webp");
        allTrainings.add(chestfly);

        GymTraining legpress = new GymTraining();
        legpress.setName("Leg Press");
        legpress.setShortDesc("The leg press is a weight training exercise in which the individual pushes a weight or resistance away from them using their legs.");
        legpress.setLongDesc("The term leg press also refers to the apparatus used to perform this exercise. The leg press can be used to evaluate an athlete's overall lower body strength (from knee joint to hip). It has the potential to inflict grave injury: the knees could bend the wrong way if they are locked during a leg press.\n" +
                "\n" +
                "\n" +
                "There are two main types of leg press:\n" +
                "\n" +
                "The diagonal or vertical 'sled' type leg press. Weight disks (plates) are attached directly to the sled, which is mounted on rails. The user sits below the sled and pushes it upward with their feet. These machines normally include adjustable safety brackets that prevent the user from being trapped under the weight.\n" +
                "The 'cable' type leg press, or 'seated leg press', commonly found on multigyms. The user sits upright and pushes forward with their feet onto a plate that is attached to the weight stack by means of a long steel cable.");
        legpress.setImageUrl("https://strongchap.com/wp-content/uploads/2019/07/proven-Leg-Press-Benefits-e1564076194111.png");
        allTrainings.add(legpress);


    }

    public static ArrayList<GymTraining> getAllTrainings() {
        return allTrainings;
    }

    public static void setAllTrainings(ArrayList<GymTraining> allTrainings) {
        Util.allTrainings = allTrainings;
    }

    public static ArrayList<Plan> getUserPlans() {
        return UserPlans;
    }

    public static void setUserPlans(ArrayList<Plan> userPlans) {
        UserPlans = userPlans;
    }

    public static boolean addToPlan(Plan plan)
    {
        return UserPlans.add(plan);
    }

    public static boolean removePlan(Plan plan)
    {
        return UserPlans.remove(plan);
    }
}
