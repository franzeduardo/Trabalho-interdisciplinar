package br.edu.univas.la4.si4.controller;

import br.edu.univas.la4.si4.listener.ListenerButtons;
import br.edu.univas.la4.si4.view.AppView;

public class AppController {

	private AppView appView;

	public AppController() {
		appView = new AppView();
	}

	public void initApplication() {
		appView.setListener(new ListenerButtons() {

			@Override
			public void listar() {
				showListPanel();
			}

			@Override
			public void cadastrar() {
				showAddPanel();
			}

			@Override
			public void remover() {
				showRemoverPanel();
			}

		});

		showListPanel();
		appView.setVisible(true);
	}

	private void showListPanel() {
		ListHospedagemController listHospedagensController = new ListHospedagemController();
		appView.getCenterPanel().removeAll();
		appView.getCenterPanel().add(listHospedagensController.getComponent());
		appView.revalidate();
	}

	private void showAddPanel() {
		AddHospedagemController addHospedagensController = new AddHospedagemController();
		addHospedagensController.init();
		appView.getCenterPanel().removeAll();
		appView.getCenterPanel().add(addHospedagensController.getComponent());
		appView.revalidate();
	}

	private void showRemoverPanel() {
		RemoverHospedagemController removerHospedagensController = new RemoverHospedagemController();
		removerHospedagensController.init();
		appView.getCenterPanel().removeAll();
		appView.getCenterPanel().add(removerHospedagensController.getComponent());
		appView.revalidate();
	}

}
