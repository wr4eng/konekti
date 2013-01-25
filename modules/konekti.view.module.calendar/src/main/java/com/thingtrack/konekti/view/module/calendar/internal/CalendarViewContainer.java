package com.thingtrack.konekti.view.module.calendar.internal;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.VerticalLayout;

import com.thingtrack.konekti.view.addon.ui.AbstractViewContainer;
import com.thingtrack.konekti.view.addon.ui.SliderView;
import com.thingtrack.konekti.view.kernel.IWorkbenchContext;
import com.thingtrack.konekti.view.kernel.ui.layout.ISliderView;
import com.thingtrack.konekti.view.kernel.ui.layout.IViewChangeListener;
import com.thingtrack.konekti.view.kernel.ui.layout.IView;

import com.thingtrack.konekti.knowledge.service.api.CalendarKnowledgeService;
import com.thingtrack.konekti.service.api.CalendarGroupService;
import com.thingtrack.konekti.service.api.CalendarService;
@SuppressWarnings("serial")
public class CalendarViewContainer extends AbstractViewContainer {

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private SliderView sliderView;

	/** Views **/
	private CalendarView calendarView;
	private CalendarCardView calendarDetailView;
	
	/** Business services **/
	@Autowired
	private CalendarService calendarService;

	//@Autowired
	//private CalendarCardService calendarCardService;

	//@Autowired
	//private CalendarDetailService calendarDetailService;
	
	//@Autowired
	//private CalendarStatusService calendarStatusService;
	
	@Autowired
	private CalendarGroupService calendarGroupService;

	@Autowired
	private CalendarKnowledgeService calendarKnowledgeService;
	
	private IWorkbenchContext context; 
	
	// Thread Local Bundle Business Services
	private static ThreadLocal<CalendarService> threadCalendarService = new ThreadLocal<CalendarService>();
	private static ThreadLocal<CalendarGroupService> threadCalendarGroupService = new ThreadLocal<CalendarGroupService>();
	//private static ThreadLocal<CalendarCardService> threadCalendarCardService = new ThreadLocal<CalendarCardService>();
	//private static ThreadLocal<CalendarDetailService> threadCalendarDetailService = new ThreadLocal<CalendarDetailService>();
	private static ThreadLocal<CalendarKnowledgeService> threadCalendarKnowledgeService = new ThreadLocal<CalendarKnowledgeService>();
	
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
		
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public CalendarViewContainer(IWorkbenchContext context) {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		this.context = context;
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void createViews() {
		// initialize thread local bundle services
		threadCalendarService.set(calendarService);
		threadCalendarGroupService.set(calendarGroupService);
		//threadCalendarCardService.set(calendarCardService);
		//threadCalendarDetailService.set(calendarDetailService);
		threadCalendarKnowledgeService.set(calendarKnowledgeService);

		
		// add all views controlled by SliderView Component
		calendarView = new CalendarView(context, this);
		sliderView.addView(calendarView);
		views.put(0, calendarView);
		
		calendarDetailView = new CalendarCardView(context, this);
		sliderView.addView(calendarDetailView);
		views.put(1, calendarDetailView);
	}

	@SuppressWarnings("unused")
	@PreDestroy
	private void destroyViews() {
		// destroy thread local bundle services
		threadCalendarService.set(null);
		threadCalendarGroupService.set(null);
		//threadCalendarCardService.set(null);
		//threadCalendarDetailService.set(null);
		threadCalendarKnowledgeService.set(null);

		
	}
	
    public static CalendarService getCalendarService() {
        return threadCalendarService.get();
        
    }

    public static CalendarGroupService getCalendarGroupService() {
        return threadCalendarGroupService.get();
        
    }
    
    /*public static CalendarCardService getCalendarCardService() {
        return threadCalendarCardService.get();
        
    }
    
    public static CalendarDetailService getCalendarDetailService() {
        return threadCalendarDetailService.get();
        
    }*/
    
    public static CalendarKnowledgeService getCalendarKnowledgeService() {
        return threadCalendarKnowledgeService.get();

    }
    
	@Override
	public ISliderView getSliderView() {
		return sliderView;
		
	}
	
	@Override
	public IView getSelectedView() {
		return sliderView.getSelectedView();
		
	}
	
	@Override
	public void addListener(IViewChangeListener listener) {
		sliderView.addListener(listener);
		
	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// sliderView_1
		sliderView = new SliderView();
		sliderView.setImmediate(false);
		sliderView.setWidth("100.0%");
		sliderView.setHeight("100.0%");
		mainLayout.addComponent(sliderView);
		mainLayout.setExpandRatio(sliderView, 1.0f);
		
		return mainLayout;
	}

}
