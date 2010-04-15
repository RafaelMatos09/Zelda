package zelda.link;

import zelda.karacter.Direction;

/**
 * @author Bas Harteveld
 */
public class DeathState extends LinkState
{
    private final String[] deathRightAnimation	= {"Link hit right", "Link death right 1", "Link death right 2"};
    private final String[] deathLeftAnimation	= {"Link hit left", "Link death left 1", "Link death left 2"};
    private final String[] deathLeft        	= {"Link death left 2"};
    private final String[] deathRight         	= {"Link death right 2"};



    public DeathState(Link link, Direction direction)
    {
        super(link);
        name = "DeathState";

        System.out.println("DeathState");

        switch(direction)
        {
            case UP:
                link.setAnimation(deathLeftAnimation);
                link.setAnimationInterval(1000);
                game.playMusic("sounds/killed.mp3", false);
                break;

            case DOWN:
                link.setAnimation(deathRightAnimation);
                link.setAnimationInterval(50);
                game.playMusic("sounds/killed.mp3", false);
                break;

            case LEFT:
                link.setAnimation(deathLeftAnimation);
                link.setAnimationInterval(50);
                game.playMusic("sounds/killed.mp3", false);
                break;

            case RIGHT:
                link.setAnimation(deathRightAnimation);
                link.setAnimationInterval(50);
                game.playMusic("sounds/killed.mp3", false);
                break;
        }
    }

    @Override
	public void handleAnimation()
	{
		int animationCounter = link.getAnimationCounter();

		//System.out.println("Animation Counter is " + animationCounter);

		//sword is done swinging revert back to former state
		if (animationCounter == link.getAnimation().length)
		{
            link.setAnimation(deathLeft);
        }
    }

    
}
