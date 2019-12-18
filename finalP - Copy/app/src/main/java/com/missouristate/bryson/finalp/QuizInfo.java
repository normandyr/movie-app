package com.missouristate.bryson.finalp;

import android.util.Log;
import java.util.Random;
public class QuizInfo {



    private String movie;
    private String[] questions;
    private String question;
    private String choices;
    private int score;
    private String response;
    private int finder;
    private String answer;
    static String[] movies = {"Avengers - Endgame", "Star Wars - The Empire Strikes Back",
            "Toy Story", "Finding Nemo", "The Incredibles"};

    static String[] star_wars_questions = {"In the asteroid sequence, one of the asteroids was actually a: ",
            "Which character says “I have a bad feeling about this?” in this particular film? ",
            "What is the correct verbage of Darth Vader’s iconic line? ", "What is the name of the bounty hunter droid sent after Han Solo? ",
            "The name of Darth Vader’s super star destroyer is? "};
    static String[] star_wars_answers = {"A: Sock, B: 2x4, C: Cassette Tape, D: Shoe", "A: Luke, B: Han, C: Leia, D: Lando",
            "A: Luke, I am your father, B: No, I am your father, C: I am your father, Luke, D: No, Luke, it is I, your father",
            "A: IG-88, B: IL-76, C: IB-44, D:IF-98",
            "A: Executor, B: Acclimator C: Eliminator D: Annihilator"};
    static String[] star_wars_correct_answers = {"D", "C", "B", "A", "A"};

    static String[] avengers_questions = {"Who was the only actor to read the entire script? ",
            "Avengers Endgame included the final the final cameo by ______ in a Marvel film. ",
            "Shot back-to-back with Avengers: Infinity War (2018) over a period of __ days? ",
            "Opening night tickets were resold on eBay for thousands of dollars, with a pair of IMAX tickets in New Jersey selling for ____ ",
            "This was the _____  numbered film to be released by Marvel Studios for the Marvel Cinematic Universe "};

    static String[] avengers_answers = {"A: Robert Downey Jr, B: Jeremy Renner, C: Scarlett Johansson D: Danai Gurira",
            "A: Stan Lee, B: Quentin Tarantino, C: Hunter S. Thompson, D: Santa",
            "A: 50, B: 75, C: 150, D: 200", "A: $10,000, B: $15,000, C: $20,000, D: $5,000", "A: 30, B: 22, C: 25 D: 19"};

    static String[] avengers_correct_answers = {"A", "A", "D", "B", "B"};

    static String[] toy_story_questions = {"How many alien toys does Sid win on the skill tester?",
            "Who lowers the driveway for the moving truck in the end scene?", "" +
            "What is Sid's little Sisters name?", "" +
            "Complete this potato head quote 'hey look___",
            "What does Sid say him and Woody will have later?"};
    static String[] toy_story_answers = {"A: 1, B: 2, C: 3 D: 4",
            "A: Little Bo Peep, B: Rocky, C: Woody D: Lenny",
            "A: Jamie, B: Hayley C: Hanna, D: Jess",
            "A: I’m Picasso, B: I’m Mixed Up, C: I’m cooler than Woody, D: I’m lonely",
            "A: Fun, B: A cook out, C: Sweet Dreams, D: Surgery"};

    static String[] toy_correct_answers = {"A", "B", "C", "A", "B"};

    static String[] nemo_questions = {"Which one of Nemo’s fins is the “lucky” one?",
            "Which character has short memory loss issues and only remembers “some” things",
            "What type of fish are Marlin and Nemo?",
            "What did Dory call the baby jellyfish?", "How did Marlins wife die?"};

    static String[] nemo_answers = {"A: Dorsal, B: Right fin, C: Left fin, D: Caudal fin",
            "A: Crush B: Bubbles C: Flo D: Dory", "A: Blowfish B: Goldfish C: Clownfish D: Anemone",
            "A: Squishy B: Bubbles C: Fishy D: Shiney",
            "A: She was captured by divers B: A shark ate her C: She had a heart attack, D: Barracuda ate her"};

    static String[] nemo_correct_answers = {"B", "D", "C", "A", "D"};

    static String[] the_incredibles_questions = {"what is Elastigirl's real name? ",
            "Why couldn't Frozone put out the fire in the burning building? ",
            "What is the password for Syndromes network?", "How did Mr. Incredible defeat the omnirobot? ",
            " What is Syndromes' name? "};
    static String[] the_incredibles_answers = {"A. Holly Parr B. Helen Parr C. Holga Parr D. Helga Parr",
            "A. He was too tired. B. Mr. Incredible made him angry and therefore due to his rage couldn't use his power. " +
                    "C. He got injured while rescuing the people in the building." +
                    "D. There was no water in the atmosphere, therefore he couldn't use his power.",
            "A. Kronos, B. Syndrome, C. Incrediboy, D. No capes.",
            "A. Throwing it into lava. B. Punching it. C. Using the omnirobot arms. D. It was Frozen by frozen.",
            "A. Buddy Pine B. Dash Parr C. Incrediboy D. Jack Jack."};
    static String[] the_incredibles_correct_answers = {"B", "D", "A", "C", "A"};

    QuizInfo() {
        this.movie = movie;
        this.questions = questions;
        this.question = question;
        this.choices = choices;
        this.answer = answer;
        this.finder = finder;
        this.score = score;
        this.response = response;

    }

    public void setMovie ( int movien){
        movie = movies[movien];


    }

    public String getMovie(){
        return movie;
    }

    public void setQuestions(String movie) {
        if(movie.equals("Avengers - Endgame")){
            Log.wtf("mainactivity", "add");
            questions = avengers_questions;
        }
        if(movie.equals("Star Wars - The Empire Strikes Back")){
            questions = star_wars_questions;
        }
        if(movie.equals("Toy Story")){
            questions = toy_story_questions;
        }
        if(movie.equals("Finding Nemo")){
            questions = nemo_questions;
        }
        if(movie.equals("The Incredibles")){
            questions = the_incredibles_questions;

        }

    }

    public String[] getQuestions(){
        return questions;
    }

    public void setQuestion(){
        String[] p = getQuestions();
        int rnd = new Random().nextInt(p.length);
        question = p[rnd];
        finder = rnd;

    }

    public String getQuestion(){
        return question;
    }

    public int getFinder(){
        return finder;
    }

    public void setchoices(){
        if(movie.equals("Avengers - Endgame")){
            choices = avengers_answers[getFinder()];
        }
        if(movie.equals("Star Wars - The Empire Strikes Back")){
            choices = star_wars_answers[getFinder()];
        }
        if(movie.equals("Toy Story")){
            choices = toy_story_answers[getFinder()];
        }
        if(movie.equals("Finding Nemo")){
            choices = nemo_answers[getFinder()];
        }
        if(movie.equals("The Incredibles")){
            choices = the_incredibles_answers[getFinder()];
        }
    }

    public void setAnswer(){
        if(movie.equals("Avengers - Endgame")){
            answer = avengers_correct_answers[getFinder()];
        }
        if(movie.equals("Star Wars - The Empire Strikes Back")){
            answer = star_wars_correct_answers[getFinder()];
        }
        if(movie.equals("Toy Story")){
            answer = toy_correct_answers[getFinder()];
        }
        if(movie.equals("Finding Nemo")){
            answer = nemo_correct_answers[getFinder()];

        }
        if (movie.equals("The Incredibles")){
            answer = the_incredibles_correct_answers[getFinder()];
        }
    }



    public String getChoices(){
        return choices;
    }

    public String getAnswer(){
        return answer;
    }

    public void setScore(int x){
        score += x;
    }

    public String getScore(){
        String x = Integer.toString(score);
        return x;
    }

    public void resetAnswer(){
        answer = null;

    }
}
