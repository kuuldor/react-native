package com.facebook.react.views.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Created by lucd on 5/13/17.
 */

public class TopLoadUrlEvent extends Event<TopLoadUrlEvent> {

  public static final String EVENT_NAME = "topWillLoadUrl";
  private WritableMap mEventData;

  public TopLoadUrlEvent(int viewId, WritableMap eventData) {
    super(viewId);
    mEventData = eventData;
  }

  @Override
  public String getEventName() {
    return EVENT_NAME;
  }

  @Override
  public boolean canCoalesce() {
    return false;
  }

  @Override
  public short getCoalescingKey() {
    // All events for a given view can be coalesced.
    return 0;
  }

  @Override
  public void dispatch(RCTEventEmitter rctEventEmitter) {
    rctEventEmitter.receiveEvent(getViewTag(), getEventName(), mEventData);
  }
}
