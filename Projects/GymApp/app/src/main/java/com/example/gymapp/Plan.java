package com.example.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Plan implements Parcelable {
    private GymTraining training;
    private int minutes;
    private String day;
    private boolean isComplete;

    public Plan(GymTraining training, int minutes, String day, boolean isComplete) {
        this.training = training;
        this.minutes = minutes;
        this.day = day;
        this.isComplete = isComplete;
    }

    public Plan() {
    }


    protected Plan(Parcel in) {
        training = in.readParcelable(GymTraining.class.getClassLoader());
        minutes = in.readInt();
        day = in.readString();
        isComplete = in.readByte() != 0;
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    @Override
    public String toString() {
        return "Plan{" +
                "training=" + training +
                ", minutes=" + minutes +
                ", day='" + day + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }

    public GymTraining getTraining() {
        return training;
    }

    public void setTraining(GymTraining training) {
        this.training = training;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(training, flags);
        dest.writeInt(minutes);
        dest.writeString(day);
        dest.writeByte((byte) (isComplete ? 1 : 0));
    }
}
