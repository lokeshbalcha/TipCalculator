
package tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.tipcalculator.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final SeekBar sb = (SeekBar) findViewById(R.id.seekBar1);
		sb.setProgress(25);
		final TextView tv1 = (TextView) findViewById(R.id.textView4);
		final TextView tv10;
		 final EditText ed = (EditText) findViewById(R.id.editText1);
		sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				Double tip = null;
				tv1.setText(progress + "");
				RadioButton r4=(RadioButton) findViewById(R.id.radio3);
				RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
				if(rg.getCheckedRadioButtonId()==r4.getId()){
					calculations();	
				}
				}}
		);	
		
		ed.addTextChangedListener(new TextWatcher() {

			
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}

			
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				if(ed.getText().toString().equals("")){
					ed.setError("Enter Bill Price");
					TextView tv7=(TextView)findViewById(R.id.textView7);
					tv7.setText("100");
					
				}
				else{
					if(Double.parseDouble(ed.getText().toString())<0){
						ed.setError("Entered Bill price should only be a positive value!");
					}
					else
						calculations();
				}
			}
		});
		
		
		final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				Double tip = null;
				if (ed.getText().toString() != null
						&& !ed.getText().toString().equals("")) {
					calculations();
					}
			}
		});
		
		//Exit Code
				Button b1=(Button)findViewById(R.id.button1);
				b1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						/*Intent intent = new Intent(Intent.ACTION_MAIN);
						intent.addCategory(Intent.CATEGORY_HOME);
						intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);*/
						finish();
					}
				});
	}

	public void calculations(){
		RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
		SeekBar sb=(SeekBar)findViewById(R.id.seekBar1);
		Double tip = null;
		 final EditText ed = (EditText) findViewById(R.id.editText1);
		Double amount = new Double(ed.getText().toString());
		RadioButton r1=(RadioButton) findViewById(R.id.radio0);
		RadioButton r2=(RadioButton) findViewById(R.id.radio1);
		RadioButton r3=(RadioButton) findViewById(R.id.radio2);
		RadioButton r4=(RadioButton) findViewById(R.id.radio3);
		TextView tv7=(TextView)findViewById(R.id.textView7);
		if (rg.getCheckedRadioButtonId()==r1.getId()) {
			tip = 0.1;
			Double ans=(amount*tip);						
			tv7.setText(Double.toString(ans));
			Double ans2=amount-ans;
		} 
		else if(rg.getCheckedRadioButtonId()==r2.getId()) {
			tip = 0.15;
			Double ans=(amount*tip);						
			tv7.setText(Double.toString(ans));

		} 
		else if(rg.getCheckedRadioButtonId()==r3.getId()) {
			tip = 0.20;
			Double ans=(amount*tip);
			tv7.setText(Double.toString(ans));
		} 
		else if(rg.getCheckedRadioButtonId()==r4.getId()){
			TextView tv12=(TextView)findViewById(R.id.textView4);
			int gp=sb.getProgress();
			tip=new Double(gp);
			Double ans=((amount*tip)/100);
			tv7.setText(Double.toString(ans));
		}
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
