//package com.mygdx.tanksv2.Tools;

package com.papertanks.desktop.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
//import com.mygdx.tanksv2.Sprites.interactiveTileObject;
import com.papertanks.desktop.Sprites.interactiveTileObject;
import sun.jvm.hotspot.ci.ciObjectFactory;

public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA=contact.getFixtureA();
        Fixture fixB=contact.getFixtureB();

        if(fixA.getUserData()== "head" ||fixB.getUserData()== "head"){
            Fixture head=fixA.getUserData()=="head"?fixA:fixB;
            Fixture object=head==fixA?fixB:fixA;

            if(object.getUserData()!=null&& interactiveTileObject.class.isAssignableFrom(object.getUserData().getClass())){
                ((interactiveTileObject) object.getUserData()).OnHeadHit();
            }
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
