package com.sergey.pisarev;

import android.app.*;
import android.icu.text.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.*;
import java.util.*;
import android.view.View.OnClickListener;
import android.graphics.*;

public class MainActivity extends Activity implements OnClickListener {
	String [] arryaNormOne={"7","14","15","17","20","25","30","33","55","70"};
	String [] arryaNormTwo={"7","14","15","17","20","25","30","33","55","70"};
	String [] arryaShift={"См.\"А\"","См.\"Б\"","См.\"В\"","См.\"Г\""};
	String [] arryaShiftWorks={"В день","В ночь","С ночи","Выходной"};
	EditText normOne;
	EditText normTwo;
	Spinner spinnerNormOne, spinnerNormTwo, spinnerShift, spinnerShiftWorks;
	Button button;
	double pr1,pr2,n1,n2,res;
	String pattern = "0.00",t;
	DecimalFormat decimalFormat = new DecimalFormat(pattern);
    TextView date,time,result;
    Calendar dateAndTime=Calendar.getInstance();
	TimePickerDialog timePickerDialog;
	DatePickerDialog datePickerDialog;
	Date dateNow=new Date();
	Date dateCounting=new Date();
	Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formatDate= new SimpleDateFormat("dd.MM.yyyy");
	Schedule schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		getActionBar().hide();	
		ArrayAdapter<String> adapterNormOne = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arryaNormOne);
		ArrayAdapter<String> adapterNormTwo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arryaNormTwo);
		ArrayAdapter<String> adapterShift=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arryaShift);
		ArrayAdapter<String> adapterShiftWorks = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arryaShiftWorks);
        adapterNormOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterNormTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapterShift.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapterShiftWorks.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerNormOne = (Spinner) findViewById(R.id.mainSpinnerOne);
		spinnerNormTwo = (Spinner) findViewById(R.id.mainSpinnerTwo);
		spinnerShift = (Spinner)findViewById(R.id.mainSpinner);
		spinnerShiftWorks = (Spinner)findViewById(R.id.mainSpinner1);
		spinnerNormOne.setAdapter(adapterNormOne);
        spinnerNormTwo.setAdapter(adapterNormTwo);
		spinnerShift.setAdapter(adapterShift);
		spinnerShiftWorks.setAdapter(adapterShiftWorks);
		spinnerNormOne.setSelection(3);
		spinnerNormTwo.setSelection(3);
		normOne = (EditText)findViewById(R.id.mainEditTextOne);
		normTwo = (EditText)findViewById(R.id.mainEditTextTwo);
	    result = (TextView)findViewById(R.id.mainTextView);
		button = (Button)findViewById(R.id.mainButton);
		button.setOnClickListener(this);
		time = (TextView) findViewById(R.id.time);
		date = (TextView)findViewById(R.id.mainTextViewDate);
		date.setText(String.valueOf(formatDate.format(dateNow)));
		date.setOnClickListener(new View.OnClickListener(){
				int day=calendar.get(Calendar.DAY_OF_MONTH);
				int month=calendar.get(Calendar.MONTH);
				int year=calendar.get(Calendar.YEAR);
				@Override
				public void onClick(View p1) {
					datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener(){
							@Override
							public void onDateSet(DatePicker p1, int p2, int p3, int p4) {
								p3++;
								if (p4 < 10 && p3 < 10) {
									date.setText("0" + p4 + "." + "0" + p3 + "." + p2);
								}
								if (p4 < 10 && p3 >= 10) {
									date.setText("0" + p4 + "." + p3 + "." + p2);
								}
								if (p4 >= 10 && p3 < 10) {
									date.setText(p4 + "." + "0" + p3 + "." + p2);
								}
								if (p4 >= 10 && p3 >= 10) {
									date.setText(p4 + "." + p3 + "." + p2);
								}
								schedule = new Schedule(String.valueOf(date.getText()));
								schedule.choiceShift(arryaShift[spinnerShift.getSelectedItemPosition()]);
								spinnerShiftWorks.setSelection(schedule.howShiftWorks());

							}
						}, year, month, day);
					datePickerDialog.show();	
				}
			});

		time.setOnClickListener(new View.OnClickListener(){
				int hour=0;
				int minute=0;

				@Override
				public void onClick(View p1) {
					timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener(){
							@Override
							public void onTimeSet(TimePicker p1, int p2, int p3) {
								if (p2 < 10 && p3 < 10) {
									time.setText("0" + p2 + ":" + "0" + p3);
								}
								if (p2 >= 10 && p3 < 10) {
									time.setText(p2 + ":" + "0" + p3);
								}
								if (p2 < 10 && p3 >= 10) {
									time.setText("0" + p2 + ":" + p3);
								}
								if (p2 >= 10 && p3 >= 10) {
									time.setText(p2 + ":" + p3);
								}
							}
						}, hour, minute, true);
					timePickerDialog.show();
				}		
			});	 

		spinnerShift.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4) {
					schedule = new Schedule(String.valueOf(date.getText()));
					schedule.choiceShift(arryaShift[spinnerShift.getSelectedItemPosition()]);
					spinnerShiftWorks.setSelection(schedule.howShiftWorks());
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1) {
					// TODO: Implement this method
				}
			});

		spinnerShiftWorks.setOnItemSelectedListener(new OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4) {
					schedule = new Schedule(String.valueOf(date.getText()));
					for (int i=0;i < arryaShift.length;i++) {
						schedule.choiceShift(arryaShift[i]);
					    if (arryaShiftWorks[spinnerShiftWorks.getSelectedItemPosition()] == arryaShiftWorks[schedule.howShiftWorks()]) {
							spinnerShift.setSelection(i);
						}
					}
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1) {
					// TODO: Implement this method
				}
			});
    }

	public void onClick(View view) {
		String m1,m2,h1,h2,m,h;
		t = String.valueOf(time.getText());
		char[] myChar=t.toCharArray();
		h1 = String.valueOf(myChar[0]);
		h2 = String.valueOf(myChar[1]);
		m1 = String.valueOf(myChar[3]);
		m2 = String.valueOf(myChar[4]);
		h = h1 + h2;
		m = m1 + m2;
		int mm=Integer.valueOf(m);
		double indexTime=Double.valueOf(h) + Double.valueOf(100.0 / 60.0 * mm / 100);
		if (normOne.getText().length() == 0 && normTwo.getText().length() == 0) {
			result.setText("");
		}
		if (normOne.getText().length() != 0 && normTwo.getText().length() == 0) {
			n1 = Double.valueOf(arryaNormOne[spinnerNormOne.getSelectedItemPosition()]);
			pr1 = Double.valueOf(String.valueOf(normOne.getText()));
			res = (pr1 / ((1 - indexTime / 11.5) * n1) - 1) * 100 + 100;
			if (res < 100) {
				result.setTextColor(Color.RED);
			}
			else {result.setTextColor(Color.GREEN);}
			result.setText(String.valueOf(decimalFormat.format(res)));
		}
		if (normOne.getText().length() != 0 && normTwo.getText().length() != 0) {
			n1 = Double.valueOf(arryaNormOne[spinnerNormOne.getSelectedItemPosition()]);
			pr1 = Double.valueOf(String.valueOf(normOne.getText()));
			n2 = Double.valueOf(arryaNormTwo[spinnerNormTwo.getSelectedItemPosition()]);
			pr2 = Double.valueOf(String.valueOf(normTwo.getText()));
			res = ((pr1 / ((1 - indexTime / 11.5) * n1) - 1) + (pr2 / n2)) * 100 + 100;
			if (res < 100) {
				result.setTextColor(Color.RED);
			}
			else {result.setTextColor(Color.GREEN);}
			result.setText(String.valueOf(decimalFormat.format(res)));
			result.setText(String.valueOf(decimalFormat.format(res)));
		}
	}
}
