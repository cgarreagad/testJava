package ec.gob.sri.dimm.factory.editors.pages;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.JAXBException;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.wb.swt.ResourceManager;


import ec.gob.sri.dimm.abt.modelo.obj.saldos.ConceptoCodigo;
import ec.gob.sri.dimm.abt.modelo.obj.saldos.SaldoContribuyente;
import ec.gob.sri.dimm.abt.modelo.valores.ModeloValoresSaldoFavor;
import ec.gob.sri.dimm.abt.ui.Activator;
import ec.gob.sri.dimm.abt.ui.dialogos.DialogoConceptoSaldo;
import ec.gob.sri.dimm.abt.ui.editores.EditorABT;
import ec.gob.sri.dimm.abt.ui.jface.ConceptoContentProvider;
import ec.gob.sri.dimm.abt.ui.jface.ConceptosTMP;
import ec.gob.sri.dimm.abt.ui.jface.ConceptoCellModifier;
import ec.gob.sri.dimm.abt.ui.jface.ConceptoLabelProvider;
import ec.gob.sri.dimm.abt.ui.paginas.util.Constantes;
import ec.gob.sri.dimm.api.ui.paginas.PaginaBase;
import ec.gob.sri.dimm.api.ui.util.eventos.AyudanteSelectionChangedEvent;

import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import swing2swt.layout.BorderLayout;


public class PaginaSaldoFavor  extends PaginaBase<EditorABT>  {
	public PaginaSaldoFavor(EditorABT editor, String id, String title) {
		super(editor, id, title);
		// TODO Auto-generated constructor stub
	}


	private DataBindingContext m_bindingContext;
	private Table table;
	TableViewer tableViewer;
	private ConceptoCodigo conceptoSeleccionado;
	private SaldoContribuyente modeloDatos; 
	private ModeloValoresSaldoFavor modeloValoresSaldo;
	
	public SaldoContribuyente getModeloDatos() {
		return modeloDatos;
	}




	public void setModeloDatos(SaldoContribuyente modeloDatos) {
		this.modeloDatos = modeloDatos;
	}


	private static final Integer SIZE_CONCEPTS=7;

	//private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	private Label lblNewLabel;
	
	/*public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(propertyName, listener);
	}*/
	
	


	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		Composite body = form.getBody();
		toolkit.paintBordersFor(body);
		
		
		ColumnLayout columnLayout = new ColumnLayout();
		columnLayout.minNumColumns = 1;
		columnLayout.maxNumColumns = 1;
		managedForm.getForm().getBody().setLayout(columnLayout);
		
		Section sctnNewSection = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.EXPANDED | Section.TWISTIE | Section.TITLE_BAR);
		ColumnLayoutData cld_sctnNewSection = new ColumnLayoutData();
		cld_sctnNewSection.heightHint = 271;
		cld_sctnNewSection.widthHint = 464;
		sctnNewSection.setLayoutData(cld_sctnNewSection);
		managedForm.getToolkit().paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Detalle Conceptos");
		sctnNewSection.setExpanded(true);
		
		Composite composite = new Composite(sctnNewSection, SWT.NONE);
		//composite.setBackground(SWTResourceManager.getColor(255, 228, 225));
		managedForm.getToolkit().adapt(composite);
		managedForm.getToolkit().paintBordersFor(composite);
		sctnNewSection.setClient(composite);
		 composite.setLayout(new FormLayout());
		
		 tableViewer = new TableViewer(composite, SWT.FULL_SELECTION);
		 tableViewer.addPostSelectionChangedListener(new ISelectionChangedListener() {
		 	public void selectionChanged(SelectionChangedEvent event) {
		 		System.out.println("addPostSelectionChangedListener");
		 	}
		 });
		table = tableViewer.getTable();
		FormData fd_table = new FormData();
		fd_table.top = new FormAttachment(20, -33);
		fd_table.bottom = new FormAttachment(100);
		fd_table.right = new FormAttachment(0, 1266);
		fd_table.left = new FormAttachment(0);
		table.setLayoutData(fd_table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		managedForm.getToolkit().paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(487);
		tblclmnNewColumn.setText("Concepto");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setAlignment(SWT.CENTER);
		tblclmnNewColumn_1.setWidth(169);
		tblclmnNewColumn_1.setText("Valor");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setAlignment(SWT.CENTER);
		tblclmnNewColumn_2.setWidth(581);
		
		 lblNewLabel = new Label(managedForm.getForm().getBody(), SWT.NONE);
		 lblNewLabel.setAlignment(SWT.RIGHT);
		 lblNewLabel.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		 managedForm.getToolkit().adapt(lblNewLabel, true, true);
		 lblNewLabel.setText("0.0");
		
		Label lblSaldoAFavor = new Label(managedForm.getForm().getBody(), SWT.NONE);
		lblSaldoAFavor.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		managedForm.getToolkit().adapt(lblSaldoAFavor, true, true);
		lblSaldoAFavor.setText("Saldo a Favor:");
		
		
		
		
		
		
		Section sctnNewSection_1 = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		ColumnLayoutData cld_sctnNewSection_1 = new ColumnLayoutData();
		cld_sctnNewSection_1.horizontalAlignment = ColumnLayoutData.LEFT;
		sctnNewSection_1.setLayoutData(cld_sctnNewSection_1);
		managedForm.getToolkit().paintBordersFor(sctnNewSection_1);
		sctnNewSection_1.setText("Ayuda");
		sctnNewSection_1.setExpanded(true);
		
		Composite composite_1 = managedForm.getToolkit().createComposite(sctnNewSection_1, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(composite_1);
		sctnNewSection_1.setClient(composite_1);
		composite_1.setLayout(new FillLayout(SWT.VERTICAL));
		
		ExpandableComposite xpndblcmpstSaldo = managedForm.getToolkit().createExpandableComposite(composite_1, ExpandableComposite.TWISTIE);
		managedForm.getToolkit().paintBordersFor(xpndblcmpstSaldo);
		xpndblcmpstSaldo.setText("Saldo a Favor");
		xpndblcmpstSaldo.setExpanded(true);
		
		FormText formText_1 = managedForm.getToolkit().createFormText(xpndblcmpstSaldo, false);
		managedForm.getToolkit().paintBordersFor(formText_1);
		xpndblcmpstSaldo.setClient(formText_1);
		formText_1.setText("<form><p>Saldo a favor del Contribuyente Seg\u00FAn Declaraci\u00F3n Impuesto a la Renta (Casilla 869 ) Per\u00EDodo Informado</p></form>", true, false);
		
		ExpandableComposite xpndblcmpstValor = managedForm.getToolkit().createExpandableComposite(composite_1, ExpandableComposite.TWISTIE);
		managedForm.getToolkit().paintBordersFor(xpndblcmpstValor);
		xpndblcmpstValor.setText("Valor");
		xpndblcmpstValor.setExpanded(true);
		
		FormText formText_2 = managedForm.getToolkit().createFormText(xpndblcmpstValor, false);
		managedForm.getToolkit().paintBordersFor(formText_2);
		xpndblcmpstValor.setClient(formText_2);
		formText_2.setText("<form><p>Valor del saldo a Favor del contribuyente respecto al Concepto Informado</p></form>", true, false);
		
		ExpandableComposite xpndblcmpstNewExpandablecomposite = managedForm.getToolkit().createExpandableComposite(composite_1, ExpandableComposite.TWISTIE);
		managedForm.getToolkit().paintBordersFor(xpndblcmpstNewExpandablecomposite);
		xpndblcmpstNewExpandablecomposite.setText("Concepto");
		xpndblcmpstNewExpandablecomposite.setExpanded(true);
		
		
		
		StringBuffer buf = new StringBuffer();
		 buf.append("<form>");
		 buf.append("<p>");
		 buf.append("Here is some plain text for the text to render; ");
		 buf.append("this text is at <a href=\"http://www.eclipse.org\" "+
		   "nowrap=\"true\">http://www.eclipse.org</a> web site.");
		 buf.append("</p>");
		 buf.append("<p>");
		 buf.append("<span color=\"header\" font=\"header\">"+
		   "This text is in header font and color.</span>");
		 buf.append("</p>");
		 buf.append("<p>This line will contain some <b>bold</b> and "+
		   "some <span font=\"code\">source</span> text. ");
		 buf.append("We can also add <img href=\"image\"/> an image. ");
		 buf.append("</p>");
		 buf.append("<li>A default (bulleted) list item.</li>");
		 buf.append("<li>Another bullet list item.</li>");
		 buf.append("<li style=\"text\" value=\"1.\">A list item with text.</li>");
		 buf.append("<li style=\"text\" value=\"2.\">Another list "+
		       "item with text</li>");
		 buf.append("<li style=\"image\" value=\"image\">List item with "+
		    "an image bullet</li>");
		 buf.append("<li style=\"text\" bindent=\"20\" indent=\"40\" value=\"3.\">"+
		   "A list item with text.</li>");
		 buf.append("<li style=\"text\" bindent=\"20\" indent=\"40\" value=\"4.\">"+
		   "A list item with text.</li>");
		 buf.append("<p>     leading blanks;      more white \n\n new "+
		   "lines   <br/>  \n   more <b>   bb   </b>  white  . </p>");
		 buf.append("</form>");
		
		
		/*FormText formText = managedForm.getToolkit().createFormText(xpndblcmpstNewExpandablecomposite, false);
		formText.setText(buf.toString(), true, false);*/
		
		 /*String RTEXT_DATA =
					"<form><p>An example of a free-form text that should be "+ //$NON-NLS-1$
					"wrapped below the section with widgets.</p>"+ //$NON-NLS-1$
					"<p>It can contain simple tags like <a>links</a> and <b>bold text</b>.</p></form>"; //$NON-NLS-1$*/
		 String RTEXT_DATA =
					"<form><p>Conceptos que comprenden el <b>Saldo a Favor del Contribuyente</b> en el Período Informado</p></form>";
		 
		FormText formText = managedForm.getToolkit().createFormText(xpndblcmpstNewExpandablecomposite, true);
		 formText.setWhitespaceNormalized(true);
		 TableWrapData td = new TableWrapData(TableWrapData.FILL);
		 td.colspan = 2;
		 formText.setLayoutData(td);
		// formText.setImage("image", FormArticlePlugin.getDefault().getImageRegistry().get(FormArticlePlugin.IMG_SAMPLE));
		 formText.setColor("header", toolkit.getColors().getColor(FormColors.TITLE));
		 formText.setFont("header", JFaceResources.getHeaderFont());
		 formText.setFont("code", JFaceResources.getTextFont());
		 formText.setText(RTEXT_DATA, true, false);
		 formText.addHyperlinkListener(new HyperlinkAdapter() {
		  public void linkActivated(HyperlinkEvent e) {
		   System.out.println("Link active: "+e.getHref());
		  }
		 });
		
			 
		
		managedForm.getToolkit().paintBordersFor(formText);
		xpndblcmpstNewExpandablecomposite.setClient(formText);
		
		
		//formText.setText("New FormText", false, false);
	
		
		form.setText("Saldos a Favor del Contribuyente");
		
		
		/*********************EDICION***********/
		
		//cargardata();
		//tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setContentProvider(new ArrayContentProvider());
		//tableViewer.setContentProvider(new ConceptoContentProvider());
		tableViewer.setLabelProvider(new ConceptoLabelProvider());
		tableViewer.setInput(modeloDatos.getConceptosSaldos().getConceptoSaldo());
		tableViewer.refresh();
		String[] PROPS= new String[]{"Concepto","Valor","Mensaje"};
		tableViewer.setColumnProperties(PROPS);
		tableViewer.setCellModifier(new ConceptoCellModifier(tableViewer));
		//Editores de Celdas
		tableViewer.setCellEditors(crearEditores(tableViewer));
		
		ToolBar tbSaldos = new ToolBar(composite, SWT.FLAT | SWT.RIGHT);
		tbSaldos.setLayoutData(new FormData());
		managedForm.getToolkit().adapt(tbSaldos);
		managedForm.getToolkit().paintBordersFor(tbSaldos);
		
		
		/*ToolBar tbRentasCab = new ToolBar(composite, SWT.FLAT | SWT.RIGHT);
		tbRentasCab.setLayoutData(BorderLayout.NORTH);
		managedForm.getToolkit().adapt(tbRentasCab);
		managedForm.getToolkit().paintBordersFor(tbRentasCab);	*/
		
		ToolItem tltmNuevoRenCab = new ToolItem(tbSaldos, SWT.NONE);
		tltmNuevoRenCab.addSelectionListener(getNuevoConceptoCabSelectionAdapter());
		tltmNuevoRenCab.setText(Constantes.ETIQUETA_NUEVO);
		
		ToolItem tltmEditarRenCab = new ToolItem(tbSaldos, SWT.NONE);
		//tltmEditarRenCab.addSelectionListener(getEditarConceptoCabSelectionAdapter());
		tltmEditarRenCab.setText(Constantes.ETIQUETA_EDITAR);
		
		ToolItem tltmEliminarRenCab = new ToolItem(tbSaldos, SWT.NONE);
		//tltmEliminarRenCab.addSelectionListener(getEliminarConceptoCabSelectionAdapter());
		tltmEliminarRenCab.setText(Constantes.ETIQUETA_ELIMINAR);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		tableViewer.addSelectionChangedListener(getSeleccionListenerSaldoFavor());
		//tableViewer.setLabelProvider(new SaldosLabelProvider());
		
		ToolBar toolBar = new ToolBar(sctnNewSection, SWT.FLAT | SWT.RIGHT);
		managedForm.getToolkit().adapt(toolBar);
		managedForm.getToolkit().paintBordersFor(toolBar);
		sctnNewSection.setTextClient(toolBar);
		
		ToolItem tltmNew = new ToolItem(toolBar, SWT.NONE);
		
		tltmNew.addSelectionListener(getCrearConceptoCodigoSelectionAdapter() );
		
		/*tltmNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				crearNuevoConcepto();
			}
		});*/
		
		tltmNew.setImage(ResourceManager.getPluginImage(Activator.PLUGIN_ID, "iconos/add_obj.gif"));
		//tltmNew.setImage(ResourceManager.getPluginImage("ec.gob.sri.dimm.factory", "icons/add_obj.gif"));
		
		ToolItem tltmDelete = new ToolItem(toolBar, SWT.NONE);
		tltmDelete.addSelectionListener(getEliminarConceptoCodigoSelectionAdapter());
		//tltmDelete.setImage(ResourceManager.getPluginImage("ec.gob.sri.dimm.factory", "icons/delete_obj.gif"));
		tltmDelete.setImage(ResourceManager.getPluginImage(Activator.PLUGIN_ID, "iconos/delete_obj.gif"));
		
		ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				exportarSectionXML();
			}
		});
		//tltmNewItem.setImage(ResourceManager.getPluginImage("ec.gob.sri.dimm.factory", "icons/export.jpg"));
		tltmNewItem.setImage(ResourceManager.getPluginImage(Activator.PLUGIN_ID, "iconos/export.jpg"));
		m_bindingContext = initDataBindings();
		
		tltmNewItem.setEnabled(false);

		
		
		
		PropertyChangeListener listener= new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				System.out.println("Cambio la propiedad="+event.getPropertyName());
				System.out.println("  OldValue=" + event.getOldValue());
				System.out.println("  NewValue=" + event.getNewValue());
				
			}
		};
		
	}

	private SelectionAdapter getNuevoConceptoCabSelectionAdapter() {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConceptoCodigo concepto = new ConceptoCodigo();
				concepto.setPropietario(modeloDatos.getConceptosSaldos());
				if (abrirDialogoConcepto(concepto)) {
					modeloDatos.agregarConceptoCodigo(concepto);					
					// Guardar Modelo
					getEditor().obtenerAdministradorPersistencia().serializarObjeto(modeloDatos.getPropietario());
				}
			}
		};
	}
	
	/*private SelectionAdapter getEditarConceptoCabSelectionAdapter() {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (rentaSeleccionada != null) {
					Renta copiaEdicion = rentaSeleccionada.crearCopiaEdicion();
					copiaEdicion.setPropietario(modeloDatos);
					
					if (abrirDialogoConcepto(copiaEdicion)) {
						rentaSeleccionada.actualizarInformacion(copiaEdicion);
						tvRentaCab.refresh();
						
						// Guardar Modelo
						getEditor().obtenerAdministradorPersistencia().serializarObjeto(modeloDatos.getPropietario());
					}
				}
			}
		};
	}*/
	
	/*private SelectionAdapter getEliminarConceptoCabSelectionAdapter() {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (rentaSeleccionada != null
						&& mostrarConfirmacion("¿Está seguro de que desea eliminar el registro seleccionado?") 
						&& modeloDatos.eliminarRenta(rentaSeleccionada)) {
					rentaSeleccionada = null;
					
					AyudanteExpandableComposite.activar(xcRentasExentasDet, false);
					
					// Guardar Modelo
					getEditor().obtenerAdministradorPersistencia().serializarObjeto(modeloDatos.getPropietario());
				}
			}
		};
	}*/
	private boolean abrirDialogoConcepto(ConceptoCodigo concepto) {
		DialogoConceptoSaldo dRentaCab = new DialogoConceptoSaldo(getSite());
		dRentaCab.setModeloDatos(concepto);
		dRentaCab.setModeloValores(modeloValoresSaldo);
		dRentaCab.create();
		
		return dRentaCab.open() == Window.OK;
	}
	protected void exportarSectionXML() {
		
		
		try {
			for (ConceptoCodigo cod:modeloDatos.getConceptosSaldos().getConceptoSaldo()){
				cod.setPropietario(null);
			}
			System.out.println("------->XML="+modeloDatos.toXML());

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private SelectionListener getCrearConceptoCodigoSelectionAdapter() {
		// TODO Auto-generated method stub
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				crearNuevoConcepto();
			}
		};
	}

	private SelectionListener getEliminarConceptoCodigoSelectionAdapter() {
		// TODO Auto-generated method stub
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					if (conceptoSeleccionado!=null
							&&  mostrarConfirmacion(Constantes.MENSAJE_CONFIRMACION_ELIMINACION)
							&& modeloDatos.getConceptosSaldos().eliminarCodigoConcepto(conceptoSeleccionado)
							) {
						conceptoSeleccionado=null;
						tableViewer.refresh();
					}
			}
		};
	}

	private ISelectionChangedListener getSeleccionListenerSaldoFavor() {
		return new ISelectionChangedListener() {		
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
					conceptoSeleccionado = AyudanteSelectionChangedEvent.<ConceptoCodigo>obtenerValorSeleccionado(event);
					
					System.out.println("Tableviewer...");
			}
		};
	}

	protected void eleminarSeleccionado() {
		tableViewer.getSelection();
		
	}

	protected void crearNuevoConcepto() {
		System.out.println("--->crearNuevoConcepto");
		
		if (modeloDatos.getConceptosSaldos().getConceptoSaldo().size()<=ConceptosTMP.INSTANCES.length ){
			ConceptoCodigo c = new ConceptoCodigo();
			c.setConcepto(BigInteger.ONE);
			c.setValor(BigDecimal.ZERO);
			c.setMensaje("");
			
			modeloDatos.agregarConceptoCodigo(c);
			
			
			//conceptos.add(c);
			tableViewer.refresh();
			//modeloDatos.setSaldoFavor(new BigDecimal("20"));
			
			//lblNewLabel.setText("40");
			//System.out.println("VAlor lbl="+lblNewLabel.getText());
		}else{
			MessageDialog.openWarning(new Shell(), "Para su información", "Ud. ha agregado el máximo permitido de conceptos");
		}
		
		
	}

	/*private void cargardata() {
		
		this.modeloDatos = new SaldoContribuyente();
		

	}*/
	
	

	private CellEditor[] crearEditores(TableViewer tableViewer) {
		
		
		CellEditor[] editors = new CellEditor[4];
		editors[0] =  new ComboBoxCellEditor(table, ConceptosTMP.INSTANCES,
		        SWT.READ_ONLY);
				/*new ComboBoxCellEditor(table, comboVal,
	            SWT.READ_ONLY);*/
		
		
		
		TextCellEditor moneyCell = new TextCellEditor(table);
	    editors[1] =moneyCell;
	    
	    
	    /*moneyCell.getControl().addListener(SWT.Verify, new Listener() {
	        public void handleEvent(Event e) {
	            String string = e.text;
	            char[] chars = new char[string.length()];
	            string.getChars(0, chars.length, chars, 0);
	            for (int i = 0; i < chars.length; i++) {
	              if (!('0' <= chars[i] && chars[i] <= '9')) {
	                e.doit = false;
	                return;
	              }
	            }
	          }
	        });*/
	    
	    ((Text)moneyCell.getControl()).addVerifyListener(new VerifyListener(){
	    	  public void verifyText(VerifyEvent event) {
	    		  
	    		    // Assume we don't allow it
	    			event.doit = false;
	    		 
	    		    // Get the character typed
	    		    char myChar = event.character;
	    		    //String text = ((Text) event.widget).getText();
	    		 
	    		 // Allow 0-9
	    		   if (Character.isDigit(myChar)) event.doit = true;
	    		 
	    		   // Allow backspace
	    		  if (myChar == '\b' || myChar=='.') {
	    		     event.doit = true;
	    		  	
	    		    }
	    		 }
	    				  
	    		});

	    
	    
	    //editors[2] = new CheckboxCellEditor(table, SWT.CHECK | SWT.READ_ONLY);
	    
	    
	    /*editors[1].setValidator(new ICellEditorValidator() {
			
			@Override
			public String isValid(Object value) {
				System.out.println("Value="+value);
				return ""+value;
			}
		});
	    
	    editors[1].addListener(new ICellEditorListener() {
			
			@Override
			public void editorValueChanged(boolean oldValidState, boolean newValidState) {
				if (!newValidState) {
					MessageDialog.openError(new Shell(),
							"No did not work", "Question");
				}

				System.out.println(oldValidState);
				System.out.println(newValidState);
				System.out.println("Changed");
				
			}
			
			@Override
			public void cancelEditor() {
				System.out.println("cancelEditor");
				
			}
			
			@Override
			public void applyEditorValue() {
				System.out.println("applyEditorValue");
				
			}
		});
		*/
	    
	    return editors;
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}


	public void setValorSuma(BigDecimal ten) {
		lblNewLabel.setText(ten.toString());
		
	}


	public void recalcularSuma() {
		BigDecimal suma=BigDecimal.ZERO;
		for (ConceptoCodigo co:modeloDatos.getConceptosSaldos().getConceptoSaldo()){
			suma = suma.add(co.getValor());
		}
		this.modeloDatos.setSaldoFavor(suma);
		this.lblNewLabel.setText(suma.toString());
		
	}




	public void inicializarModeloValores() {
		
		modeloValoresSaldo = new ModeloValoresSaldoFavor();
		modeloValoresSaldo.inicializar();
	}
}
