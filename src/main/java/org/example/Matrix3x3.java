package org.example;

public class Matrix3x3 {
    double[] values;

    public Matrix3x3() {
        values = new double[9];
    }

    public Matrix3x3(double[] values) {
        this.values = values;
    }

    public Matrix3x3 multiply(Matrix3x3 other) {
        double[] result = new double[9];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                for (int k = 0; k < 3; k++) {
                    result[row * 3 + col] += this.values[row * 3 + k] * other.values[k * 3 + col];
                }
            }
        }
        return new Matrix3x3(result);
    }

    public Vertex transform(Vertex v) {
        return new Vertex(
                this.values[0] * v.x + this.values[3] * v.y + this.values[6] * v.z,
                this.values[1] * v.x + this.values[4] * v.y + this.values[7] * v.z,
                this.values[2] * v.x + this.values[5] * v.y + this.values[8] * v.z
        );
    }

    public static Matrix3x3 scale(double factor) {
        return new Matrix3x3(new double[] {
                factor, 0, 0,
                0, factor, 0,
                0, 0, factor
        });
    }
}
