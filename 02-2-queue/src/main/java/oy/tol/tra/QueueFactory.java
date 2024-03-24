package oy.tol.tra;

/**
 * This class instantiates a queue implementing the {@code QueueInterface}.
 * 
 * @author Antti Juustila
 */
public class QueueFactory {

   private QueueFactory() {
   }

   /**
    * Creates an instance of QueueInterface for Integer type with the specified capacity.
    * 
    * @param capacity Number of elements the queue can hold.
    * @return The queue object.
    */
   public static QueueInterface<Integer> createIntegerQueue(int capacity) {
      // Instantiate your QueueImplementation class with the given capacity
      return new QueueImplementation<>(capacity);
   }

   /**
    * Creates an instance of QueueInterface for Integer type using the default constructor.
    * 
    * @return The queue object.
    */
   public static QueueInterface<Integer> createIntegerQueue() {
      // Instantiate your QueueImplementation class with the default capacity
      return new QueueImplementation<>();
   }

}

