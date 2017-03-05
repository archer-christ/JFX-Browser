package userInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXDrawer.DrawerDirection;

import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Hamburger {

	public MenuView menuView = new MenuView();
	public  JFXDrawersStack drawersStack = new JFXDrawersStack();
	public  JFXDrawer rightDrawer = new JFXDrawer();
	JFXButton home = new JFXButton();
	JFXButton history = new JFXButton();
	JFXButton downloads = new JFXButton();
	JFXButton bookmarks = new JFXButton();
	JFXButton saveAsPdf = new JFXButton();
	JFXButton setting = new JFXButton();
	
	public  JFXHamburger getHamburger(JFXHamburger hamburger, BorderPane borderpane, TabPane settingTabPane) {

		home.setMinSize(80, 60);
		home.setGraphic(new ImageView(new Image("/homeBlack.png")));
		home.addEventHandler(MouseEvent.DRAG_DETECTED, (e)->{
			
			home.setStyle("fx-background-color: derive(#28323c,5.0%);");
		});
		home.addEventHandler(MouseEvent.MOUSE_DRAGGED, (e)->{
		});
		// home.setButtonType(ButtonType.RAISED);//
		// home.getStyleClass().addAll("animated-option-button","animated-option-sub-button2");
		
		history.setMinSize(80, 60);
		history.setGraphic(new ImageView(new Image("/historyBlack.png")));
		
		downloads.setMinSize(80, 60);
		downloads.setGraphic(new ImageView(new Image("/downloadBlack.png")));
		
		bookmarks.setMinSize(80, 60);
		bookmarks.setGraphic(new ImageView(new Image("/collectionBookmark.png")));
		
		saveAsPdf.setMinSize(80, 60);
		saveAsPdf.setGraphic(new ImageView(new Image("/pdf.png")));
	
		setting.setMinSize(80, 60);
		setting.setGraphic(new ImageView(new Image("/settingBlack.png")));

		// Tooltips Referance: menus
		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Tooltip.html
		home.setTooltip(new Tooltip("Home"));
		history.setTooltip(new Tooltip("History"));
		downloads.setTooltip(new Tooltip("Downloads"));
		bookmarks.setTooltip(new Tooltip("Bookmarks"));
		saveAsPdf.setTooltip(new Tooltip("Save As PDF"));
		setting.setTooltip(new Tooltip("Setting"));

		// ------------------------------------------------------Drawer-Menus----------------------------------------
		/*
		 * Below is the menu view list that will appear from right side when
		 * clicked the hamburger.
		 */
		
	
		VBox vbox = new VBox();
		vbox.getChildren().addAll(home,history,downloads,bookmarks,saveAsPdf,setting);
		vbox.setSpacing(10);
		
		// ----------------------------------------------Right----DrawerStack----Add Drawer pane----------------------------
		/*
		 * Drawerstack is container for drawer. We set the place of drawer is
		 * right whenever user clicked the hamburger it will appear from right
		 * side.Its defulte size 40 and we placed the --Draw-Menus-- in this
		 * drawer.
		 */

		rightDrawer.setDirection(DrawerDirection.RIGHT);
		rightDrawer.setDefaultDrawerSize(80);
		rightDrawer.setSidePane(vbox);
				
		// --------------------------------------------------------Hamburger------------------------------------------------

		borderpane.setRight(drawersStack);
		hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			showHamburgerPane();
		});

		// -----------------------------------------------------Menview-Class method ----menuView----------------------------------------------
		/*
		 * We are just sending all listener to another class as in this way can
		 * easily manager the listener Menu view. The purpose whenever one menu
		 * is clicked then this menView method send action event to MenuView
		 * Class method menuView.
		 */
		menuView.setMenuViewListener(home, history, downloads, bookmarks, saveAsPdf, setting, settingTabPane,
				 drawersStack, rightDrawer);
		// setting.getStyleClass().addAll("animated-option-button","animated-option-sub-button2");
		setHistoryBtn(history);
		return hamburger;
	}

	public  void showHamburgerPane() {
		drawersStack.toggle(rightDrawer);
	}

	public void hideHamburgerPane() {

		drawersStack.toggle(rightDrawer, false);

	}


	public void setHistoryBtn(JFXButton history) {
		this.history = history;
	}

	public JFXButton getHistory() {
		return history;
	}
}
