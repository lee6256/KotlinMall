// Java
if (view != null) {
  if (view.getParent() != null) {
    if (view.getParent() instanceof ViewGroup) {
      ((ViewGroup) view.getParent()).removeView(view);
    }
  }
}

// Kotlin
(view?.getParent() as? ViewGroup)?.removeView(view)
