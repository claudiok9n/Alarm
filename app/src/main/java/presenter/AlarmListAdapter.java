package presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.claudio_pc.alarm.R;

import model.model.entity.Alarm;
import java.util.List;

/**
 * Created by csantamaria on 11/05/2016.
 */
public class AlarmListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater = null;
    private List<Alarm> alarms = null;

    public AlarmListAdapter(Context _context, List<Alarm> _alarms){
        context = _context;
        alarms = _alarms;
    }

    @Override
    public int getCount() {
        return alarms.size();
    }

    @Override
    public Object getItem(int position) {
        return alarms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder viewHolder;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(itemView == null){
            itemView = layoutInflater.inflate(R.layout.alarm_list_item, parent, false);
            viewHolder = new ViewHolder(itemView);
            itemView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) itemView.getTag();
        }

        viewHolder.name.setText(alarms.get(position).getName());
        viewHolder.hour.setText(alarms.get(position).getHour());
        viewHolder.checkBoxD.setChecked(getDaysChecked(alarms.get(position).getDays(), 0));
        viewHolder.checkBoxL.setChecked(getDaysChecked(alarms.get(position).getDays(), 1));
        viewHolder.checkBoxM.setChecked(getDaysChecked(alarms.get(position).getDays(), 2));
        viewHolder.checkBoxX.setChecked(getDaysChecked(alarms.get(position).getDays(), 3));
        viewHolder.checkBoxJ.setChecked(getDaysChecked(alarms.get(position).getDays(), 4));
        viewHolder.checkBoxV.setChecked(getDaysChecked(alarms.get(position).getDays(), 5));
        viewHolder.checkBoxS.setChecked(getDaysChecked(alarms.get(position).getDays(), 6));

        return itemView;
    }

    private class ViewHolder{
        TextView name, hour;
        CheckBox checkBoxD, checkBoxL, checkBoxM, checkBoxX, checkBoxJ, checkBoxV, checkBoxS;

        public ViewHolder(View v){
            name = (TextView) v.findViewById(R.id.name_textView);
            hour = (TextView) v.findViewById(R.id.hour_textView);

            checkBoxD = (CheckBox) v.findViewById(R.id.checkBoxD);
            checkBoxL = (CheckBox) v.findViewById(R.id.checkBoxL);
            checkBoxM = (CheckBox) v.findViewById(R.id.checkBoxM);
            checkBoxX = (CheckBox) v.findViewById(R.id.checkBoxX);
            checkBoxJ = (CheckBox) v.findViewById(R.id.checkBoxJ);
            checkBoxV = (CheckBox) v.findViewById(R.id.checkBoxV);
            checkBoxS = (CheckBox) v.findViewById(R.id.checkBoxS);
        }
    }

    private boolean getDaysChecked(String days, int day){
        String[] value = null;
        Boolean resu = false;
        value = days.split("-");
        if(value[day].equals("1"))
            resu = true;
        return resu;
    }
}
