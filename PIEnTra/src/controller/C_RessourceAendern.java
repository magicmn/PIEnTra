/**
 * Aktuelle Version: 1.3
 * Authoren: Julian (1.0), Adrian (1.1, 1.2), Andreas (1.1), K0nstantin (1.3)
 * 
 * Changelog:
 * 1.3
 * 		-Singelton Implementiert* 
 * 1.2
 * 		-ActionListener wieder entfernt und in View implementiert!
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.0 	
 * 		-Controller erstellt
 *
 **/


package controller;

import java.lang.reflect.GenericArrayType;

import model.M_Ort;
import model.M_Produkt;
import model.M_Trainer;
import view.V_KundeSuchen;
import view.V_RessourceAendern;

public class C_RessourceAendern {
	private static C_RessourceAendern instance = null;
	private static V_RessourceAendern view;
	private static Object controller;
	private M_Produkt produkt;
	private M_Trainer trainer;
	private M_Ort ort;

	private C_RessourceAendern (Object controller){
		setController(controller);
		getView();
	}

	public static V_RessourceAendern getView() {

		if(view==null) {
			view = new V_RessourceAendern(controller);
			
		}
//		V_RessourceAendern.setController(controller);

		

		view.setVisible(true);
		return view;

	}

	public void setView(V_RessourceAendern view) {
		C_RessourceAendern.view = view;

	}

	public static C_RessourceAendern getInstance(Object controller) {

		if(instance==null) {
			instance = new C_RessourceAendern(controller);
		}
		setController(controller);
	
		return instance;
	}

	public static Object getController() {
		return controller;
	}

	public static void setController(Object controller) {
		C_RessourceAendern.controller = controller;
	}

	//	public void ressourcenSetzen(M_Produkt produkt, M_Trainer trainer, M_Ort ort) {
	//		if(ort!=null&&produkt!=null&&trainer!=null) {
	//			if(controller instanceof C_TrainingAendern) {
	//
	//				view.dispose();
	//			}
	////			if(controller instanceof C_KundeWaehlen) {
	//
	//				view.dispose();
	//			}
	//		}
	//
	//	}

	public void viewSetzen(M_Produkt produkt, M_Trainer trainer, M_Ort ort) {
		setProdukt(produkt);
		setTrainer(trainer);
		setOrt(ort);

	}

	public M_Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(M_Produkt produkt) {
		this.produkt = produkt;
	}

	public M_Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(M_Trainer trainer) {
		this.trainer = trainer;
	}

	public M_Ort getOrt() {
		return ort;
	}

	public void setOrt(M_Ort ort) {
		this.ort = ort;
	}

}


