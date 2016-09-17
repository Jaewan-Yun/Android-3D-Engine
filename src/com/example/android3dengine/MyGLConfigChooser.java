package com.example.android3dengine;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

import android.opengl.GLSurfaceView;
import android.util.Log;

public class MyGLConfigChooser implements GLSurfaceView.EGLConfigChooser {
	@Override
	public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
		int attribs[] = {
		                 EGL10.EGL_LEVEL, 0,
		                 EGL10.EGL_RENDERABLE_TYPE, 4,  // EGL_OPENGL_ES2_BIT
		                 EGL10.EGL_COLOR_BUFFER_TYPE, EGL10.EGL_RGB_BUFFER,
		                 EGL10.EGL_RED_SIZE, 8,
		                 EGL10.EGL_GREEN_SIZE, 8,
		                 EGL10.EGL_BLUE_SIZE, 8,
		                 EGL10.EGL_DEPTH_SIZE, 16,
		                 EGL10.EGL_SAMPLE_BUFFERS, 1,
		                 EGL10.EGL_SAMPLES, 4,  // 4x MSAA.
		                 EGL10.EGL_NONE
		};
		EGLConfig[] configs = new EGLConfig[1];
		int[] configCounts = new int[1];
		egl.eglChooseConfig(display, attribs, configs, 1, configCounts);

		if (configCounts[0] == 0) {
			Log.e("ANDROID 3D ENGINE", "Config not set at MyGLConfigChooser#chooseConfig");
			Log.e("ANDROID 3D ENGINE", "error", new Exception());
			return null;
		} else {
			return configs[0];
		}
	}
}
