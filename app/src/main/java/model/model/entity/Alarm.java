package model.model.entity;

/**
 * Created by csantamaria on 11/05/2016.
 */
public class Alarm {
    private int code;
    private String name;
    private String hour;
    private String days;
    private boolean week_repeat;
    private String sound;
    private String repeat;
    private int leave_alarm_type;
    private Boolean active;
    private int state_id;

    public Alarm(){
        code = 0;
        name = null;
        hour = null;
        days = null;
        week_repeat = false;
        sound = null;
        repeat = null;
        leave_alarm_type = 0;
        active = false;
        state_id = 0;
    }

    public Alarm(int code, String name, String hour, String days, boolean week_repeat, String sound, String repeat, int leave_alarm_type, boolean active, int state_id){
        this.code = code;
        this.name = name;
        this.hour = hour;
        this.days = days;
        this.week_repeat = week_repeat;
        this.sound = sound;
        this.repeat = repeat;
        this.leave_alarm_type = leave_alarm_type;
        this.active = active;
        this.state_id = state_id;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHour(){
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public boolean isWeek_repeat() {
        return week_repeat;
    }

    public void setWeek_repeat(boolean week_repeat) {
        this.week_repeat = week_repeat;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public int getLeave_alarm_type() {
        return leave_alarm_type;
    }

    public void setLeave_alarm_type(int leave_alarm_type) {
        this.leave_alarm_type = leave_alarm_type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }
}
