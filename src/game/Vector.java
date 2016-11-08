/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Point;

/**
 *
 * @author LHP5025
 */
public class Vector {
    // Members
    private double x;
    private double y;
    
    // Constructor
    public Vector(Point _p1, Point _p2) {
        this.x = _p2.getX() - _p1.getX();
        this.y = _p2.getY() - _p1.getY();
    }
    
    public Vector(double _x, double _y) {
        this.x = _x;
        this.y = _y;
    }
    
    public Vector(Vector _v1, double _const_mult) {
        this.x = _v1.getX() * _const_mult;
        this.y = _v1.getY() *_const_mult;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setX(double n) {
        this.x = n;
    }
    
    public void setY(double n) {
        this.y = n;
    }
    
    public void incX(double n) {
        this.x += n;
    }
    
    public void incY(double n) {
        this.y += n;
    }
    
    public void incLocation(double n1, double n2) {
        this.x += n1; this.y += n2;
    }
    
    public double length() {
        return Math.sqrt(this.x*this.x + this.y * this.y );
    }
    
    public Vector normalize() {
        if (this.length() > 0){
            return new Vector(this, 1.0 / this.length());
        }
        return this; // since it is a zero vector
    }
    
    public static boolean compareParralel(Vector _v1, Vector _v2){
        // Compare normals
        return (Math.abs(_v1.normalize().getX()) == Math.abs(_v2.normalize().getX())) && (Math.abs(_v1.normalize().getY()) == Math.abs(_v2.normalize().getY()));
    }
    
    public static double calcCrossProductLength(Vector _v1, Vector _v2){
        return Math.abs(_v1.getX() * _v2.getY() - _v2.getX() * _v1.getY());
    }
     
     public static double calcDotProduct(Vector _v1, Vector _v2){
        return _v1.getX() * _v2.getX() + _v2.getY() * _v1.getY();
    }
}
