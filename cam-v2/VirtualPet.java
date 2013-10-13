public class VirtualPet {

    VirtualPetFace face;
    int hunger = 0;   // how hungry the pet is.
    int tiredness = 10;
    int age = 0;

    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
        face.setMessage("Hi! Who are you?");
    }

    public void feed() {
        if (hunger > 10) {
            hunger = hunger - 10;
        } else {
            hunger = 0;
        }
        tiredness = tiredness + 2;
        if (tiredness > 15) {
            face.setMessage("I'm... too... sleepy...");
            sleep();
        } else {
            face.setMessage("Yum, thanks");
            face.setImage("normal");
            reset();
        }

        grow();
    }

    public void exercise() {
        hunger = hunger + 3;
        tiredness = tiredness + 1;

        if (tiredness > 15) {
            face.setMessage("I'm... too... sleepy...");
            sleep();
        }
        else if (hunger > 12) {
            face.setMessage("urk, I'm too hungry!");
            die();
        } else {   
            face.setMessage("1, 2, 3, jump.  Whew.");
            face.setImage("tired");
            executeABriefLullInTime();
            reset();
        }

        grow();
    }

    public void sleep() {
        hunger = hunger + 1;
        tiredness = 10;
        age += 1;
        if (tiredness > 12) {
            face.setMessage("awww, I got too hungry!");
            die();
        } else {
            face.setMessage("zzzzzzzzzz");
            face.setImage("asleep");
        }

        grow();
    }

    public void askGirlOut() {
        if (Math.random() < 0.5) {
            face.setImage("depressed");
            face.setMessage("i'm all out of luck");
        } else {
            face.setImage("ecstatic");
            face.setMessage("AWW YEAH");
            executeABriefLullInTime();
            face.setImage("love");
        }

    }

    public void reset() {
        face.setImage("normal");
    }

    public void grow() {
        age += 1;
        if (age >= 15) {
            die();
        } else {
            face.setMessage("It's my birthday! I just turned " + age + ".");
        }
    }

    public void die() {
        face.setMessage("I don't feel so well");
        face.setImage("sick");
        executeABriefLullInTime();
        face.setImage("dead");
        executeABriefLullInTime();
        face.setMessage("RIP");
        face.setImage("pushingdaisies");
        sleep();
        for (int i = 0; i < 3; i++) {
            face.setMessage("...");
            executeABriefLullInTime();
        }
        face = new VirtualPetFace();
        face.setImage("normal");
        face.setMessage("Hi! Who are you?"); 
    }

    private void executeABriefLullInTime() {
        try {
            Thread.sleep(2000);
        } catch(Exception e) {
        }    
    }

}
