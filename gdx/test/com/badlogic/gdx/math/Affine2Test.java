package com.badlogic.gdx.math;

import static org.junit.Assert.*;
import org.junit.Test;

public class Affine2Test {
	
    @Test
    public void testIdentity() {
    	Affine2 matrix = new Affine2();
        matrix.idt();
        assertEquals(1, matrix.m00, 0.001);
        assertEquals(0, matrix.m01, 0.001);
        assertEquals(0, matrix.m02, 0.001);
        assertEquals(0, matrix.m10, 0.001);
        assertEquals(1, matrix.m11, 0.001);
        assertEquals(0, matrix.m12, 0.001);
    }

    @Test
    public void testSetTranslation() {
    	Affine2 matrix = new Affine2();
        matrix.setToTranslation(3, 5);
        assertEquals(1, matrix.m00, 0.001);
        assertEquals(0, matrix.m01, 0.001);
        assertEquals(3, matrix.m02, 0.001);
        assertEquals(0, matrix.m10, 0.001);
        assertEquals(1, matrix.m11, 0.001);
        assertEquals(5, matrix.m12, 0.001);
    }

    @Test
    public void testSetScaling() {
    	Affine2 matrix = new Affine2();
        matrix.setToScaling(2, 4);
        assertEquals(2, matrix.m00, 0.001);
        assertEquals(0, matrix.m01, 0.001);
        assertEquals(0, matrix.m02, 0.001);
        assertEquals(0, matrix.m10, 0.001);
        assertEquals(4, matrix.m11, 0.001);
        assertEquals(0, matrix.m12, 0.001);
    }

    @Test
    public void testSetRotationDegrees() {
    	Affine2 matrix = new Affine2();
        matrix.setToRotation(90);
        assertEquals(0, matrix.m00, 0.001);
        assertEquals(-1, matrix.m01, 0.001);
        assertEquals(0, matrix.m02, 0.001);
        assertEquals(1, matrix.m10, 0.001);
        assertEquals(0, matrix.m11, 0.001);
        assertEquals(0, matrix.m12, 0.001);
    }

    @Test
    public void testSetRotationRadians() {
    	Affine2 matrix = new Affine2();
        matrix.setToRotationRad((float) Math.PI / 2);
        assertEquals(0, matrix.m00, 0.001);
        assertEquals(-1, matrix.m01, 0.001);
        assertEquals(0, matrix.m02, 0.001);
        assertEquals(1, matrix.m10, 0.001);
        assertEquals(0, matrix.m11, 0.001);
        assertEquals(0, matrix.m12, 0.001);
    }

    @Test
    public void testSetShearing() {
    	Affine2 matrix = new Affine2();
        matrix.setToShearing(1, 2);
        assertEquals(1, matrix.m00, 0.001);
        assertEquals(1, matrix.m01, 0.001);
        assertEquals(0, matrix.m02, 0.001);
        assertEquals(2, matrix.m10, 0.001);
        assertEquals(1, matrix.m11, 0.001);
        assertEquals(0, matrix.m12, 0.001);
    }

    @Test
    public void testTranslate() {
    	Affine2 matrix = new Affine2();
        matrix.translate(5, 10);
        assertEquals(1, matrix.m00, 0.001);
        assertEquals(0, matrix.m01, 0.001);
        assertEquals(5, matrix.m02, 0.001);
        assertEquals(0, matrix.m10, 0.001);
        assertEquals(1, matrix.m11, 0.001);
        assertEquals(10, matrix.m12, 0.001);
    }

    @Test
    public void testScale() {
    	Affine2 matrix = new Affine2();
        matrix.scale(3, 3);
        assertEquals(3, matrix.m00, 0.001);
        assertEquals(0, matrix.m01, 0.001);
        assertEquals(0, matrix.m02, 0.001);
        assertEquals(0, matrix.m10, 0.001);
        assertEquals(3, matrix.m11, 0.001);
        assertEquals(0, matrix.m12, 0.001);
    }

    @Test
    public void testRotate() {
    	Affine2 matrix = new Affine2();
        matrix.rotate(45);
        float expectedCos = (float) Math.cos(Math.toRadians(45));
        float expectedSin = (float) Math.sin(Math.toRadians(45));
        assertEquals(expectedCos, matrix.m00, 0.001);
        assertEquals(-expectedSin, matrix.m01, 0.001);
        assertEquals(0, matrix.m02, 0.001);
        assertEquals(expectedSin, matrix.m10, 0.001);
        assertEquals(expectedCos, matrix.m11, 0.001);
        assertEquals(0, matrix.m12, 0.001);
    }

    @Test
    public void testSetToProduct() {
    	Affine2 matrix = new Affine2();
        Affine2 matrixA = new Affine2().setToScaling(2, 2);
        Affine2 matrixB = new Affine2().setToTranslation(3, 3);
        matrix.setToProduct(matrixA, matrixB);

        assertEquals(2, matrix.m00, 0.001);
        assertEquals(0, matrix.m01, 0.001);
        assertEquals(6, matrix.m02, 0.001);
        assertEquals(0, matrix.m10, 0.001);
        assertEquals(2, matrix.m11, 0.001);
        assertEquals(6, matrix.m12, 0.001);
    }

    @Test
    public void testInverse() {
    	Affine2 matrix = new Affine2();
        matrix.setToTranslation(3, 3).scale(2, 2);
        matrix.inv();
        assertEquals(0.5, matrix.m00, 0.001);
        assertEquals(0, matrix.m01, 0.001);
        assertEquals(-1.5, matrix.m02, 0.001);
        assertEquals(0, matrix.m10, 0.001);
        assertEquals(0.5, matrix.m11, 0.001);
        assertEquals(-1.5, matrix.m12, 0.001);
    }

    @Test
    public void testDeterminant() {
    	Affine2 matrix = new Affine2();
        matrix.setToScaling(3, 4);
        assertEquals(12, matrix.det(), 0.001);
    }
}

