package com.xcds.mobile.cztalentnet.act;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import com.mdx.mobile.Frame;
import com.mdx.mobile.activity.MActivity;
import com.mdx.mobile.json.Updateone2json;
import com.mdx.mobile.manage.Updateone;
import com.mdx.mobile.server.Son;
import com.xcds.mobile.cztalentnet.F;
import com.xcds.mobile.cztalentnet.adapter.IndexAdAdapter;
import com.xcds.mobile.cztalentnet.dialog.Exitdialog;
import com.xcds.mobile.cztalentnet.jsonClass.Plogin;
import com.xcds.mobile.cztalentnet.jsonClass.ZticketorderDetail;
import com.xcds.mobile.cztalentnet.widget.DragChangeView;
import com.xcds.mobile.cztalentnet.widget.Headlayout;

/***************
 * 
 * @author Roy
 * 
 */
public class ActNav extends MActivity implements OnClickListener {

	private static final int INDEX_ADS = 1;
	private static final int LOGIN_AS_PERSON = 2;
	private static final int LOGIN_AS_ENTERPRISE = 3;

	private DragChangeView mDragChangeView;
	private Headlayout headlayout;

	private String FILE = "saveUserNamePwd";
	private SharedPreferences sp = null;
	private String logintype = "";
	private String pername, perpsw, comname, compsw;
	private boolean success = false;

	@Override
	protected void create(Bundle arg0) {
		setContentView(R.layout.navigation);
		Frame.init(this);
		this.setId("navigation");
		init();
	}

	private void init() {
		initLoginInfo();
		initViews();
		loadDragViewImages();
	}

	private void initLoginInfo() {
		success = getIntent().getBooleanExtra("success", false);
		sp = getSharedPreferences(FILE, MODE_PRIVATE);
		logintype = sp.getString("logintype", "");
		if (!success) {
			if (logintype.equals("person")) {
				pername = sp.getString("name", "").trim();
				perpsw = sp.getString("password", "").trim();
				dataLoad(new int[] { LOGIN_AS_PERSON });
			} else if (logintype.equals("company")) {
				comname = sp.getString("qiyename", "").trim();
				compsw = sp.getString("qiyepassword", "").trim();
				dataLoad(new int[] { LOGIN_AS_ENTERPRISE });
			}
		} else {
			if (F.USER_TYPE.equals("geren")) {
				F.USER_TYPE = "geren";
			} else if (F.USER_TYPE.equals("qiye")) {
				F.USER_TYPE = "qiye";
			}
		}
	}

	private void initViews() {
		initHeadLayout();
		initDragChangeView();
		initNavBtns();
	}

	private void initHeadLayout() {
		headlayout = (Headlayout) findViewById(R.nav.header);
		headlayout.setLeftviewGone();
		headlayout.showRight();
		headlayout.setRightBg(R.drawable.bt_head_login);
		headlayout.setTitle("");
		headlayout.setOnClickRight(this);
	}

	private void initDragChangeView() {
		mDragChangeView = (DragChangeView) findViewById(R.nav.drag_change_view);
		mDragChangeView.setAutoMove(false);
		mDragChangeView.setNoCurrIcon(R.drawable.ic_poi_w);
		mDragChangeView.setCurrIcon(R.drawable.ic_poi_g);
		mDragChangeView.setMoveIcon(R.drawable.ic_poi_g);
		mDragChangeView.setRadius(7);
	}

	private void initNavBtns() {
		int[] btnIds = new int[] { R.nav.btn_rsrcxx, R.nav.btn_jlcx,
				R.nav.btn_qyzp, R.nav.btn_zphxx, R.nav.btn_zwss,
				R.nav.btn_grqz, R.nav.btn_mqzp, R.nav.btn_zcfg, R.nav.btn_ywjs };
		for (int id : btnIds) {
			findViewById(id).setOnClickListener(this);
		}
	}

	private void loadDragViewImages() {
		dataLoad(new int[] { INDEX_ADS });
	}

	@Override
	public void dataLoad(int[] types) {
		switch (types[0]) {
		case INDEX_ADS:
			loadData(new Updateone[] { new Updateone2json("INDEXADS",
					new String[][] {}) });
			break;
		case LOGIN_AS_PERSON:
			loadData(new Updateone[] { new Updateone2json("LOGIN",
					new String[][] { { "username", pername },
							{ "pwd", perpsw }, { "type", "1" } }) });
			break;
		case LOGIN_AS_ENTERPRISE:
			loadData(new Updateone[] { new Updateone2json("LOGIN",
					new String[][] { { "username", comname },
							{ "pwd", compsw }, { "type", "2" } }) });
			break;
		default:
			throw new IllegalStateException("Unsupported Data Load Type");
		}
	}

	@Override
	public void disposeMessage(Son son) throws Exception {
		if (son.build == null)
			return;
		if (son.mgetmethod.equals("INDEXADS")) {
			ZticketorderDetail builder = (ZticketorderDetail) son.build;
			IndexAdAdapter ada = new IndexAdAdapter(this, builder.tickets);
			mDragChangeView.setAdapter(ada);
		} else if (son.mgetmethod.equals("LOGIN")) {
			Plogin builder = (Plogin) son.build;
			if (builder.success.equals("0")) {
				F.USER_ID = builder.uid;
				F.USER_PSW = perpsw;
				F.USER_ISVIP = builder.isvip;
				if (builder.jumptype.equals("1")) {
					F.USER_TYPE = "geren";
				} else if (builder.jumptype.equals("2")) {
					F.USER_TYPE = "qiye";
				}
			}
		}
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		Class<?> cls = null;
		switch (id) {
		case R.nav.btn_rsrcxx:
			cls = RenshiRencaiXinXiAct.class;
			break;
		case R.nav.btn_jlcx:
			cls = SearchresumeAct.class;
			break;
		case R.nav.btn_qyzp:
			cls = isLoginAs("qiye") ? RecruitmentAct.class : LoginAct.class;
			break;
		case R.nav.btn_zphxx:
			cls = ZhaoPinHuiXinXiAct.class;
			break;
		case R.nav.btn_zwss:
			cls = JobsearchAct.class;
			break;
		case R.nav.btn_grqz:
			cls = isLoginAs("geren") ? JobseekingAct.class : LoginAct.class;
			break;
		case R.nav.btn_mqzp:
			cls = HiringListAct.class;
			break;
		case R.nav.btn_zcfg:
			cls = RegulationAct.class;
			break;
		case R.nav.btn_ywjs:
			cls = SiteRecruitmentAct.class;
			break;
		case R.headlayout.right:// setting
			cls = SettingAct.class;
			break;
		default:
			throw new IllegalStateException("Unsupported Click Listener");
		}
		if (cls != null) {
			Intent intent = new Intent(this, cls);
			if (id == R.nav.btn_qyzp || id == R.nav.btn_grqz) {
				String jumpstate = id == R.nav.btn_qyzp ? "qiye" : "geren";
				intent.putExtra("jumpstate", jumpstate);
			}
			startActivity(intent);
		}
	}

	private boolean isLoginAs(String type) {
		return F.USER_TYPE.equals(type) && !F.USER_ID.equals("");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Exitdialog exit = new Exitdialog(this);
			exit.show();
			return true;
		}
		return false;
	}

}
