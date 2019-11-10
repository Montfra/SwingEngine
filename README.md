# SwingEngine
Very little 2d game Engine, made with java swing. Use it for project that don't have great performance requirement like strategy game.

## How to use
 - First create the engine's instance
```Java
int widthOfTheWindow = 800;
int heightOfTheWindow = 600;
SwingEngine engine = new SwingEngine("nameOfYourGame", widthOfTheWindow, heightOfTheWindow);
```

### Menu
- Then create a menu panel, the menu panel is the main menu
```Java
  MenuPanel menu = new MenuPanel("nameOfYourMenu");
  menu.addComponent(new JButton("uselessButton"));
```
- You can change style, or add a play button on sub menu or on menu panel like that
```Java
  menu.setHorizontalAlignement();
  menu.addPlayButton(engine);
```

- You can add sub menu to your main menu
```Java
  SubMenuPanel subMenu = new SubMenuPanel("nameOfYourSubMenu");
  subMenu.addPlayButton(engine);
  
  menu.addSubMenu(subMenu);
```

- Now you have to add button to navigate between sub menu
To add button on main menu which go to sub menu
```Java
  menu.addSubMenuButton("nameOfTheButton", subMenu);
```
To add button on sub menu which go to an other sub menu
```Java
  menu.addSubMenuButtonOnSubMenu(subMenuToAddButton, "nameOfTheButton", otherSubMenuToGoingTo);
```
       
- When you have done with your sub menu and menu, you must add the menu panel to the engine
```Java
  engine.setMenu(menu);
```
 
 
### Game
- Create a sprite of character
```Java
    int initialXPosition = 0;
    int initialYPosition = 0;
    int initialWidthSize = 128;
    int initialHeightSize = 128;
    Sprite character = new Sprite("pathToImageFile", new Position(initialXPosition, initialYPosition), initialWidthSize, initialHeightSize);
 ```
  
  - add annimation to character
  ```Java
  int xPositionInImageOfSprite = 0;
  int yPositionInImageOfSprite = 0;
  int numberOfSubImageOfThisAnimation = 8;
  int sizeOfOneSubImageOfAnimation = 100;
  int speedOfAnimation = 1;
  character.addAnimation("nameAndIndentifierOfAnimation", new Animation(xPositionInImageOfSprite, yPositionInImageOfSprite, numberOfSubImageOfThisAnimation, sizeOfOneSubImageOfAnimation, speedOfAnimation));
  ```
  
  - add the sprite to the engine
  ```Java
  character.setActualState("nameAndIndentifierOfAnimation");
  engine.addDrawer(character);
  ```
  
  - now you can select a animation like this
  if you want to show animation until next selection
  ```Java
  character.setActualState("nameAndIndentifierOfAnimation");
  ```
  
  if you want to show animation x time, you must specify what animation play after
  ```Java
  int numberOfTimePlayAnimation = 2;
  character.setActualState("nameAndIndentifierOfAnimation", numberOfTimePlayAnimation, "nameAndIndentifierOfAnimationAfter");
  ```
  
  
  - add controller to control your main character
  isKeyRealease is equals to 0, action start when key is pressed.
  isKeyRealease is equals to 1, action start when key is released.
  ```Java
  int isKeyRealease = 0;
  engine.addController(KeyEvent.VK_LEFT, isKeyRealease, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Left is clicked");
            }
        });
  ```
  
- Finaly you can run the game ;)
```Java
  engine.run();
```