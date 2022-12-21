//package com.mygdx.tanksv2.Tools;
package com.papertanks.desktop.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
//import com.mygdx.tanksv2.Sprites.Floor;
import com.papertanks.desktop.Sprites.Floor;

public class b2WorldCreator {
    public b2WorldCreator(World world, TiledMap map){
        BodyDef bdef=new BodyDef();
        PolygonShape shape= new PolygonShape();
        FixtureDef fdef= new FixtureDef();
        Body body;

        for(MapObject object: map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject) object).getRectangle();
            new Floor(world,map,rect);

        }
    }

    }