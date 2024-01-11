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

import java.lang.RuntimeException;

/**
 * Cette classe permet la création de carrés.<br />
 * Cette classe hérite de Rectangle. En effet, il s'agit d'un rectangle particulier où la Area_Height et la Area_Width sont égales.
 * <br /><br />
 * Elle hérite de la classe Rectangle afin que toutes les méthodes de la classe Rectangle s'applique également à celle-ci. Attention, de nombreuses méthodes (notamment les construteurs) peuvent lancer des exceptions. Pour plus d'informations, voir la classe Rectangle.
 * @author Equipe 2D, Rémi Synave
 * @version 2.9
 * @see Rectangle
 */
public class Carre extends Rectangle {

    // Constructeurs //

    /**
     * Construit un carré noir de (0,0) à (1,1).
     */
    public Carre(){
	super(new Point(),1,1);
    }

    /**
     * Construit un carré à partir d'un autre Carre.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * @param c Le carré à copier.
     */
    public Carre ( Carre c ) {

	super ( c );
    }

    // Sans couleur //

    /**
     * Construit un carré à partir d'un point min et d'un entier correspondant à la dimension des côtés.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * @param a Coin bas gauche.
     * @param taille Dimension des côtés.
     * @see Point
     */
    public Carre ( Point a, int taille ) {

	super ( a, taille, taille );
    }

    /**
     * Construit un carré à partir de coin bas gauche et de la taille de ses côtés.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * @param a Coin bas gauche.
     * @param taille Dimension des côtés.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @see Point
     */
    public Carre ( Point a, int taille, boolean plein ) {

	super ( a, taille, taille, plein );
    }

    /**
     * Construit un carré dont les bords sont arrondis à partir du coin bas gauche, de la taille de ses côtés et de la dimension des arrondis.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * @param a Coin bas gauche.
     * @param taille Dimension des côtés.
     * @param arcArea_Width Arrondis en Area_Width.
     * @param arcArea_Height Arrondis en Area_Height.
     * @see Point
     */
    public Carre ( Point a, int taille, int arcArea_Width, int arcArea_Height ) {

	super ( a, taille, taille, arcArea_Width, arcArea_Height );
    }

    /**
     * Construit un carré dont les bords sont arrondis à partir du coin bas gauche, de la taille de ses côtés et de la dimension des arrondis.<br />
     * Il s'agit du constructeur sans couleur, ainsi l'objet sera noir.
     * @param a Coin bas gauche.
     * @param taille Dimension des côtés.
     * @param arcArea_Width Arrondis en Area_Width.
     * @param arcArea_Height Arrondis en Area_Height.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @see Point
     */
    public Carre ( Point a, int taille, int arcArea_Width, int arcArea_Height, boolean plein ) {

	super ( a, taille, taille, arcArea_Width, arcArea_Height, plein );
    }

    // Avec couleur //

    /**
     * Construit un carré à partir du coin bas gauche et de la taille de ses côtés.<br />
     * @param couleur Couleur de l'objet.
     * @param a Coin bas gauche.
     * @param taille Dimension des côtés.
     * @see Couleur
     * @see Point
     */
    public Carre ( Couleur couleur, Point a, int taille ) {

	super ( couleur, a, taille, taille );
    }

    /**
     * Construit un carré à partir du coin bas gauche et de la taille de ses côtés.<br />
     * @param couleur Couleur de l'objet.
     * @param a Coin bas gauche.
     * @param taille Dimension des côtés.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @see Couleur
     * @see Point
     */
    public Carre ( Couleur couleur, Point a, int taille, boolean plein ) {

	super ( couleur, a, taille, taille, plein );
    }

    /**
     * Construit un carré dont les bords sont arrondis à partir du coin bas gauche, de la taille de ses côtés et de la taille des arrondis.<br />
     * @param couleur Couleur de l'objet.
     * @param a Coin bas gauche.
     * @param taille Dimension des côtés.
     * @param arcArea_Width Arrondis en Area_Width.
     * @param arcArea_Height Arrondis en Area_Height.
     * @see Couleur
     * @see Point
     */
    public Carre ( Couleur couleur, Point a, int taille, int arcArea_Width, int arcArea_Height ) {

	super ( couleur, a, taille, taille, arcArea_Width, arcArea_Height );
    }

    /**
     * Construit un carré dont les bords sont arrondis à partir du coin bas gauche, de la taille de ses côtés et de la taille de ses arrondis.<br />
     * @param couleur Couleur de l'objet.
     * @param a Coin bas gauche.
     * @param taille Taille des côtés.
     * @param arcArea_Width Arrondis en Area_Width.
     * @param arcArea_Height Arrondis en Area_Height.
     * @param plein Défini si la forme doit être dessinée pleine ou non.
     * @see Couleur
     * @see Point
     */
    public Carre ( Couleur couleur, Point a, int taille, int arcArea_Width, int arcArea_Height, boolean plein ) {

	super ( couleur, a, taille, taille, arcArea_Width, arcArea_Height, plein );
    }

    // Accesseurs //

    // Getter //

    /**
     * Retourne la taille des côtés.<br />
     * Cette taille n'étant pas stockée directement par un attribut, elle est obtenue par un calcul simple : bx - ax.
     * @return La taille des côtés.
     */
    public int getTaille () {

	return ( this.getB().getX() - this.getA().getX() );
    }

    /**
     * Fixe une nouvelle position au coin bas gauche du carré.<br />
     * L'une des conséquences de cette méthode est que le carré se déplace.
     * @param p Nouvelles coordonnées du coin bas gauche du carré.
     * @see Point
     */
    public void setA(Point p){
	int taille=getTaille();
	super.setB( new Point ( p.getX()+taille, p.getY() + taille ) );
	super.setA(p);
    }

    /**
     * Fixe une nouvelle position au coin haut droit du carré.<br />
     * L'une des conséquences de cette méthode est que le carré se déplace.
     * @param p Nouvelles coordonnées du coin haut droit du carré.
     * @see Point
     */
    public void setB(Point p){
	int taille=getTaille();
	super.setA( new Point ( p.getX()-taille, p.getY() - taille ) );
	super.setB(p);
    }

    /**
     * Permet la modification de la Area_Height du carré.<br />
     * Le coin haut droit sera repositionné.
     * @param Area_Height Nouvelle Area_Height du carré.
     */
    public void setArea_Height(int Area_Height){
	super.setB( new Point ( getA().getX() + Area_Height, getA().getY() + Area_Height ) );
    }

    /**
     * Permet la modification de la Area_Width du carré.<br />
     * Le coin haut droit sera repositionné.
     * @param Area_Width Nouvelle Area_Width de l'image.
     */
    public void setArea_Width(int Area_Width){
	super.setB ( new Point ( getA().getX() + Area_Width, getA().getY() + Area_Width) );
    }

    /**
     * Permet la modification de la taille du carré.<br />
     * Le coin haut droit sera repositionné.
     * @param taille Nouvelle taille du carré.
     */
    public void setTaille(int taille){
	super.setB ( new Point ( getA().getX() + taille, getA().getY() + taille) );
    }

    /**
     * <strong>Redéfinition : </strong> Permet la modification de la taille du carré.<br />
     * La Area_Width et la Area_Height d'un carré étant les mêmes, si les paramètres Area_Width et Area_Height ne sont pas égaux, alors la méthode lance un exception RuntimeException.
     * @param Area_Width nouvelle Area_Width de l'image
     * @param Area_Height nouvelle Area_Height de l'image
     * @exception java.lang.RuntimeException Cette exception est lancée si :<ul><li>les arrondis ont des dimensions négatives</li><li>si on tente de construire un carré avec des dimensions négatives</li><li>si le coin bas gauche et au dessus ou à droite du coin haut droit.</li></ul>.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html" target="_blank">RuntimeException</a>
     */
    public void setTaille(int Area_Width, int Area_Height){
	if(Area_Width!=Area_Height){
	    throw new RuntimeException("Vous essayez de créer un Carré de Area_Width "+Area_Width+" et de Area_Height "+Area_Height+". Un carré doit avoir la même Area_Width que la Area_Height.");
	}
	else
	    super.setB ( new Point ( getA().getX() + Area_Width, getA().getY() + Area_Height ) );
    }

    // Méthodes //

    /**
     * Implémentation de la méthode afficher() de la classe abstraite Dessin.<br />
     * Elle permet d'afficher un Carre sur la zone d'affichage.
     * <br /><br />
     * On récupère d'abord la couleur de l'objet afin de le dessiner dans la bonne couleur. Ensuite, on vérifie si l'objet est arrondis et plein, arrondis ou plein pour appeler les méthodes adéquates. Sinon on utilise l'affichage de base avec drawRect().
     * @param g Graphics.
     */
    public void afficher ( Graphics g ) {

	g.setColor ( getCouleur() );

	if ( getArrondi() && getPlein() )
	    g.fillRoundRect ( this.getA().getX(), (int)g.getClipBounds().getHeight()-this.getA().getY()-getTaille(), getTaille(), getTaille(), getArcArea_Width(), getArcArea_Height() );

	else if ( getArrondi() )
	    g.drawRoundRect ( this.getA().getX(), (int)g.getClipBounds().getHeight()-this.getA().getY()-getTaille(), getTaille(), getTaille(), getArcArea_Width(), getArcArea_Height() );

	else if ( getPlein() )
	    g.fillRect ( this.getA().getX(), (int)g.getClipBounds().getHeight()-this.getA().getY()-getTaille(), getTaille(), getTaille() );

	else
	    g.drawRect ( this.getA().getX(), (int)g.getClipBounds().getHeight()-this.getA().getY()-getTaille(), getTaille(), getTaille() );
    }
}
