# Jets Program

# Description
Week 3's 'Jets' project does the following:

Once the application is launched, the program reads the data from a text file into an ArrayList for later use. The user is met with a title screen and prompted to enter his/her 'Call Sign', at which point "Basic Training" begins. A menu is presented to the user with 10 different choices:

- List Fleet
- Fly All Jets
- View Fastest Jet
- View Jet With Longest Range
- Bomb
- Attack
- Add a Jet to Fleet
- Remove a Jet From Fleet
- Quit
- Menu

The fields mostly display data regarding planes within the fleet, from listing the all aircraft currently in the fleet, to viewing the fastest jet, and even the jet with the longest range. The user can also call on the entire fleet to take flight, the bombers within the fleet to execute a bombing demonstration, and the fighters show off by firing some heat-seeking missiles (Fox 2). Next up, the user is given the ability to add a jet of their own to the fleet by providing information for the following fields: role, model, speed, range, and price. The user can also choose to remove a jet from the fleet if they wish by simply inputting an aircraft's corresponding number that represents its position in the list. The final two options are 'Quit' and 'Menu'. Choosing 'Quit' will first prompt the user to confirm that they really want to exit the program with a 'y' or 'n' response, at which point the user is either escorted out with a bit of banter and a farewell, or they will be returned to the Menu to continue browsing the application. Inputting '0' will display the Menu once again if it has traveled to high up the terminal. 

# Tech Used
Java, GitHub, Git, Eclipse, Atom

# Lessons Learned

Where do I begin? Another week, another project bigger than the last. It goes without saying that this was a very challenging project. The most challenging aspect was not just keeping track of more files than usual, but also trying to keep as much code out of the class with main method as possible, while also being mindful of the 4 pillars of Object Oriented Programming (Abstraction, Polymorphism, Inheritance, and Encapsulation). This experience also helped to provide me a better understanding of method calls. Not just within the same file, but across the enter program. Calling methods from different classes, and being able to override existing methods inherited from abstract parent classes. Last but not least, reading file data from text files and inserting that data into a list was also quite challenging. It took many attempts and iterations to get the code to work the way intended. I'm very grateful to this project for helping me connect some dots and discover some weak points that need to be reinforced moving forward with the cohort. As of now, areas that require more attention are ArrayLists and the BufferedReader.