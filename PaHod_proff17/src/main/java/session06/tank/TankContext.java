package session06.tank;

/**
 * Created by PaHod on 20.05.2014.
 */
public class TankContext {
    public MoveStrategy moveStrategy = new TrackSrategyImpl();
    public FireStrategy fireStrategy = new SinglShootStrategyImpl();

    public void move(){
moveStrategy.move();
    }

    public void fire(){
fireStrategy.fire();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
      this.moveStrategy = moveStrategy;
    }

    public void setFireStrategy(FireStrategy fireStrategy){
    this.fireStrategy=fireStrategy;
}

}
