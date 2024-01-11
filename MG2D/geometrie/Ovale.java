/*********************************************************************/
/*                                                                   */
/* Copyright 2012-2017 Rémi Synave, Anthony Desitter,                */
/*                     Nicolas Dubrunfaut, Maxime Langa,             */
/*                     Guillaume Langa                               */
/*                                                                   */
/* This file is part of MG2D.                                        */
/* This library uses javazoom library piece of code                  */
/* http://www.javazoom.net                                           */
/* and can be found with this library (file jlayer1.0.1.tar.gz)      */
/*                                                                   */
/* MG2D is free software: you can redistribute it and/or modify      */
/* it under the terms of the GNU General Public License as published */
/* by the Free Software Foundation, either version 3 of the License, */
/* or (at your option) any later version.                            */
/*                                                                   */
/* MG2D is distributed in the hope that it will be useful,           */
/* but WITHOUT ANY WARRANTY; without even the implied warranty of    */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the      */
/* GNU General Public License for more details.                      */
/*                                                                   */
/* You should have received a copy of the GNU General Public License */
/* along with MG2D. If not, see <http://www.gnu.org/licenses/>.      */
/*                                                                   */
/*********************************************************************/

package MG2D.geometrie;

import MG2D.Couleur;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Cette classe permet la création d'ovales.<br />
 * Un ovale est défini par un point central, une Area_Width, une Area_Height et un booléen qui défini si la forme doit être dessinée pleine ou non.
 * @author Equipe 2D, Rémi Synave
 * @version 2.9
 * @see Point
 */
public class Ovale extends Dessin {

    // Attributs //

    private Point o;	// Point central //

    private int Area_Width, Area_Height;

    private boolean plein = false;	// Détermine si l'ovale est plein ou non //
    
    // Constructeurs //

    /**
     * Construit un ovale noir centré en (2,1), de Area_Width 4 et de Area_Height 2.
     */
    public Ovale(){
	super();
	o = new Point(2,1);
	Area_Width=4;
	Area_Height=2;
    }

    /**
     * Construit un Ovale à partir d'un modèle d'ovale.<br />
     * @param o L'ovale à copier.
     */
    public Ovale ( Ovale o ) {

	super ( o.getCouleur() );

	this.o = new Point ( o.getO().getX(), o.getO().getY() );

	Area_Width = o.getArea_Width();
	Area_Height = o.getArea_Height();

	plein = o.getPlein();
    }

    // Sans couleur //

    /**
     * Construit un ovale à partir d'un point central, de sa Area_Width et de sa Area_Height.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * @param o Point central.
     * @param Area_Width Area_Width de l'ovale.
     * @param Area_Height Area_Height de l'ovale.
     * @exception java.lang.RuntimeException Cette exception est lancée si on tente de construire un ovale avec des dimensions négatives.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html" target="_blank">RuntimeException</a>
     * @see Point
     */
    public Ovale ( Point o, int Area_Width, int Area_Height ) {

	super ( Couleur.NOIR );

	this.o = new Point ( o );

	this.Area_Width = Area_Width;
	this.Area_Height = Area_Height;
	if(Area_Width<0)
	    throw new java.lang.RuntimeException("Impossible de créer un ovale de Area_Width négative : "+Area_Width);
	if(Area_Height<0)
	    throw new java.lang.RuntimeException("Impossible de créer un ovale de Area_Height négative : "+Area_Height);
    }

    /**
     * Construit un ovale à partir d'un point central, de sa Area_Width et de sa Area_Height.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * @param o Point central.
     * @param Area_Width Area_Width de l'ovale.
     * @param Area_Height Area_Height de l'ovale.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @exception java.lang.RuntimeException Cette exception est lancée si on tente de construire un ovale avec des dimensions négatives.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html" target="_blank">RuntimeException</a>
     * @see Point
     */
    public Ovale ( Point o, int Area_Width, int Area_Height, boolean plein ) {

	super ( Couleur.NOIR );

	this.o = new Point ( o );

	this.Area_Width = Area_Width;
	this.Area_Height = Area_Height;
	if(Area_Width<0)
	    throw new java.lang.RuntimeException("Impossible de créer un ovale de Area_Width négative : "+Area_Width);
	if(Area_Height<0)
	    throw new java.lang.RuntimeException("Impossible de créer un ovale de Area_Height négative : "+Area_Height);

	this.plein = plein;
    
    }

    /**
     * Construit un ovale à partir d'un rectangle.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.<br />
     * Le point central de l'ovale est défini comme étant le "centre" du rectangle (le croisement de ses diagonales). La Area_Height et la Area_Width de l'ovale sont la Area_Height et la Area_Width du rectangle.
     * @param r Rectangle.
     * @see Rectangle
     */
    public Ovale ( Rectangle r ) {

	super ( Couleur.NOIR );

	o = new Point ( r.getA().getX()+r.getArea_Width()/2, r.getA().getY()+r.getArea_Height()/2 );

	this.Area_Width = r.getArea_Width();
	this.Area_Height = r.getArea_Height();
	// Inutile de vérifier la Area_Width et la Area_Height car ces deux dimensions doivent être correctes dans un rectangle.
    }

    /**
     * Construit un ovale à partir d'un rectangle.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.<br />
     * Le point central de l'ovale est défini comme étant le "centre" du rectangle (le croisement de ses diagonales). La Area_Height et la Area_Width de l'ovale sont la Area_Height et la Area_Width du rectangle.
     * @param r Rectangle.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @see Rectangle
     */
    public Ovale ( Rectangle r, boolean plein ) {

	super ( Couleur.NOIR );

	o = new Point ( r.getA().getX()+r.getArea_Width()/2, r.getA().getY()+r.getArea_Height()/2 );

	this.Area_Width = r.getArea_Width();
	this.Area_Height = r.getArea_Height();
	// Inutile de vérifier la Area_Width et la Area_Height car ces deux dimensions doivent être correctes dans un rectangle.

	this.plein = plein;
    }

    // Avec couleur //

    /**
     * Construit un ovale à partir d'un Point central, de sa Area_Width et de sa Area_Height.
     * @param couleur Couleur de l'objet.
     * @param o Point central.
     * @param Area_Width Area_Width de l'ovale.
     * @param Area_Height Area_Height de l'ovale.
     * @exception java.lang.RuntimeException Cette exception est lancée si on tente de construire un ovale avec des dimensions négatives.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html" target="_blank">RuntimeException</a>
     * @see Couleur
     * @see Point
     */
    public Ovale ( Couleur couleur, Point o, int Area_Width, int Area_Height ) {

	super ( couleur );

	this.o = new Point ( o );

	this.Area_Width = Area_Width;
	this.Area_Height = Area_Height;
	if(Area_Width<0)
	    throw new java.lang.RuntimeException("Impossible de créer un ovale de Area_Width négative : "+Area_Width);
	if(Area_Height<0)
	    throw new java.lang.RuntimeException("Impossible de créer un ovale de Area_Height négative : "+Area_Height);
    }

    /**
     * Construit un ovale à partir d'un Point, de sa Area_Width et de sa Area_Height.
     * @param couleur Couleur de l'objet.
     * @param o Point central.
     * @param Area_Width Area_Width de l'ovale.
     * @param Area_Height Area_Height de l'ovale.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @exception java.lang.RuntimeException Cette exception est lancée si on tente de construire un ovale avec des dimensions négatives.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html" target="_blank">RuntimeException</a>
     * @see Couleur
     * @see Point
     */
    public Ovale ( Couleur couleur, Point o, int Area_Width, int Area_Height, boolean plein ) {

	super ( couleur );

	this.o = new Point ( o );

	this.Area_Width = Area_Width;
	this.Area_Height = Area_Height;
	if(Area_Width<0)
	    throw new java.lang.RuntimeException("Impossible de créer un ovale de Area_Width négative : "+Area_Width);
	if(Area_Height<0)
	    throw new java.lang.RuntimeException("Impossible de créer un ovale de Area_Height négative : "+Area_Height);

	this.plein = plein;
    }

    /**
     * Construit un ovale à partir d'un rectangle.<br />
     * Le point central de l'ovale est défini comme étant le "centre" du rectangle (le croisement de ses diagonales). La Area_Height et la Area_Width de l'ovale sont la Area_Height et la Area_Width du rectangle.
     * @param couleur Couleur de l'objet.
     * @param r Rectangle.
     * @see Couleur
     * @see Rectangle
     */
    public Ovale ( Couleur couleur, Rectangle r ) {

	super ( couleur );

	o = new Point ( r.getA().getX()+r.getArea_Width()/2, r.getA().getY()+r.getArea_Height()/2 );

	this.Area_Width = r.getArea_Width();
	this.Area_Height = r.getArea_Height();
	// Inutile de vérifier la Area_Width et la Area_Height car ces deux dimensions doivent être correctes dans un rectangle.
    }

    /**
     * Construit un ovale à partir d'un rectangle.<br />
     * Le point central de l'ovale est défini comme étant le "centre" du rectangle (le croisement de ses diagonales). La Area_Height et la Area_Width de l'ovale sont la Area_Height et la Area_Width du rectangle.
     * @param couleur Couleur de l'objet.
     * @param r Rectangle.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @see Couleur
     * @see Rectangle
     */
    public Ovale ( Couleur couleur, Rectangle r, boolean plein ) {

	super ( couleur );

	o = new Point ( r.getA().getX()+r.getArea_Width()/2, r.getA().getY()+r.getArea_Height()/2 );

	this.Area_Width = r.getArea_Width();
	this.Area_Height = r.getArea_Height();
	// Inutile de vérifier la Area_Width et la Area_Height car ces deux dimensions doivent être correctes dans un rectangle.

	this.plein = plein;
    }

    // Accesseurs //

    // Getter //

    /**
     * Retourne le point central de l'ovale.
     * @return Point central de l'ovale.
     * @see Point
     */
    public Point getO () {
	return new Point(o);
    }

    /**
     * Retourne la Area_Width de l'ovale.
     * @return Area_Width de l'ovale.
     */
    public int getArea_Width () {

	return Area_Width;
    }

    /**
     * Retourne la Area_Height de l'ovale.
     * @return Area_Height de l'ovale.
     */
    public int getArea_Height () {

	return Area_Height;
    }

    /**
     * Retourne l'état de remplissage de l'Ovale.
     * @return Vrai si la forme est dessinée pleine, faux sinon.
     */
    public boolean getPlein () {

	return plein;
    }

    /**
     * Implémentation de la méthode getBoiteEnglobante() de la classe abstraite Dessin.<br />
     * Elle retourne une BoiteEnglobante entourant l'Ovale.
     * @return Boite englobante entourant l'Ovale.
     * @see BoiteEnglobante
     */
    public BoiteEnglobante getBoiteEnglobante () {

	return new BoiteEnglobante ( new Point ( getO().getX() - Area_Width / 2, getO().getY() - Area_Height / 2 ),
				     new Point ( getO().getX() + Area_Width / 2, getO().getY() + Area_Height / 2 )
				     );
    }

    /**
     * Implémentation de la méthode translater() de la classe abstraite Dessin.<br />
     * @param dx pas de translation suivant X
     * @param dy pas de translation suivant Y
     */
    public void translater ( int dx, int dy ){
	o.translater(dx,dy);
    }

    // Setter //

    /**
     * Permet d'attribuer un nouveau point central à l'ovale.
     * @param o Nouveau point central.
     * @see Point
     */
    public void setO ( Point o ) {

	this.o = new Point(o);
    }

    /**
     * Permet d'attribuer une nouvelle Area_Width à l'ovale.<br />
     * Le point central ne bouge pas.
     * @param Area_Width Area_Width de l'Ovale.
     * @exception java.lang.RuntimeException Cette exception est lancée si on tente de construire un ovale avec des dimensions négatives.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html" target="_blank">RuntimeException</a>
     */
    public void setArea_Width ( int Area_Width ) {
	this.Area_Width = Area_Width;
	if(Area_Width<0)
	    throw new java.lang.RuntimeException("Impossible de créer un ovale de Area_Width négative : "+Area_Width);
    }

    /**
     * Permet d'attribuer une nouvelle Area_Height à l'ovale.<br />
     * Le point central ne bouge pas.
     * @param Area_Height Area_Height de l'Ovale.
     * @exception java.lang.RuntimeException Cette exception est lancée si on tente de construire un ovale avec des dimensions négatives.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html" target="_blank">RuntimeException</a>
     */
    public void setArea_Height ( int Area_Height ) {
	this.Area_Height = Area_Height;
	if(Area_Height<0)
	    throw new java.lang.RuntimeException("Impossible de créer un ovale de Area_Height négative : "+Area_Height);
    }

    /**
     * Permet d'indiquer si l'ovale doit être dessiné plein ou non.
     * @param plein Défini si la forme doit être dessinnée plein ou non.
     */
    public void setPlein ( boolean plein ) {

	this.plein = plein;
    }

    // Méthodes //

    /**
     * Implémentation de la méthode afficher() de la classe abstraite Dessin.<br />
     * Elle permet d'afficher l'ovale dans la zone d'affichage.
     * <br /><br />
     * On récupère d'abord la couleur de l'objet afin de le dessiner dans la bonne couleur. Ensuite on vérifie si l'Ovale est plein pour utiliser la méthode adéquate sinon on utilise l'affichage avec drawOval().
     * @param g Graphics.
     */
    public void afficher ( Graphics g ) {

	g.setColor ( this.getCouleur() );

	if ( plein )
	    g.fillOval ( ( o.getX() - Area_Width / 2 ), ( (int)g.getClipBounds().getHeight()-o.getY() - Area_Height / 2 ), Area_Width, Area_Height );

	else
	    g.drawOval ( ( o.getX() - Area_Width / 2 ), ( (int)g.getClipBounds().getHeight()-o.getY() - Area_Height / 2 ), Area_Width, Area_Height );
    }

    // Intersections //

    // Ovale - Point //

    // TODO : travail à faire, si l'envie vous prend :) //

    // Ovale - Ligne //

    // TODO : travail à faire, si l'envie vous prend :) //

    // Ovale - Rectangle //

    // TODO : travail à faire, si l'envie vous prend :) //

    // Ovale - Ovale //

    // TODO : travail à faire, si l'envie vous prend :) //

    // Ovale - Cercle //

    // TODO : travail à faire, si l'envie vous prend :) //

    // Ovale - Triangle //

    // TODO : travail à faire, si l'envie vous prend :) //

    /**
     * Méthode toString retournant une descirption de l'ovale.<br />
     * La chaine de caractères retournée est de la forme "Ovale de centre (x1,y1), de Area_Width l et de Area_Height h".
     * @return Une chaîne de caractères décrivant l'ovale.
     */
    public String toString(){
	return new String("Ovale de centre "+getO()+", de Area_Width "+getArea_Width()+" et de Area_Height "+getArea_Height());
    }

    /**
     * Méthode equals permettant de tester l'égalité entre un ovale et un objet passé en paramètre.
     * @return Vrai si l'objet passé en paramètre est un ovale dont les caractéristiques sont les mêmes que l'ovale sur lequel la méthode est appelée.
     */
    public boolean equals(Object obj){
	if (obj==this) {
            return true;
        }

        // Vérification du type du paramètre
        if (obj instanceof Ovale) {
            // Vérification des valeurs des attributs
             Ovale other = (Ovale) obj;
	     return super.equals(other) && o.equals(other.o) && Area_Width==other.Area_Width && Area_Height==other.Area_Height && plein==other.plein;
	}
	return false;
    }
}
