/** An EventQ implements a priority queue of Events ordered by time.
 */
 
class EventQ {
  private long lastTime = 0;
  private Event head = null;
  static private EventQ INSTANCE = null;
  private EventQ() {} //Ensure cannot be instantiated outside class (Singleton)
  
  /**
   *
   * Return Singleton instance of EventQ.
   */
  static public EventQ getInstance()
  {
      if (INSTANCE == null) {
          INSTANCE = new EventQ();
      }
      return INSTANCE;
  }
  
  /** Add an Event to the queue.  The single parameter is:
   * @param event The Event to add.
   */
  @SuppressWarnings("empty-statement")
  public void add(Event event)
  {
    if (head == null) {
      head = event;
    } else {
      long et = event.getTime();
      Event p = null;
      Event n = head;
      for(;(n != null) && (et >= n.getTime()); p = n, n = n.next)
        ;
      if (p != null) {
        p.next = event;
        event.next = n;
      } else {
        head = event;
        event.next = n;
      }
    }
  }

  /** Return the next Event and delete it from the queue.
   * @return The next Event or <tt> null</tt> if the queue is empty.
   */
  public Event delete()
  {
    if (head == null)
      return null;
    Event deleted = head;
    head = deleted.next;
    lastTime = deleted.getTime();
    return deleted;
  }

  /** Return the current simulation time.
   * @return The time of the last deleted Event--i.e. the current
   * simulation time.  If the simulation has not yet started (i.e.
   * no Events have yet been deleted), minus one (-1) is returned.
   */
  public long getSimulationTime()
  {
    return lastTime;
  }
  
  void reset()
  {
      lastTime = 0;
      head = null;
  }
}

