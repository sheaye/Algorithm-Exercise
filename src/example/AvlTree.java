package example;

public class AvlTree<T extends Comparable<T>> {

    static class AvlNode<T> {

        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        public AvlNode(T element) {
            this.element = element;
        }

        public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

    }

    private AvlNode<T> mRoot;

    private int height(AvlNode<T> t) {
        return t == null ? 0 : t.height;
    }

    private AvlNode<T> leftLeftRotation(AvlNode<T> oldParent) {
        AvlNode<T> newParent = oldParent.left;
        oldParent.left = newParent.right;
        newParent.right = oldParent;
        oldParent.height = Math.max(height(oldParent.left), height(oldParent.right)) + 1;
        newParent.height = Math.max(height(newParent.left), height(oldParent.right)) + 1;
        return newParent;
    }

    private AvlNode<T> rightRightRotation(AvlNode<T> oldParent) {
        AvlNode<T> newParent = oldParent.right;
        oldParent.right = newParent.left;
        newParent.left = oldParent;
        oldParent.height = Math.max(height(oldParent.left), height(oldParent.right)) + 1;
        newParent.height = Math.max(height(newParent.left), height(oldParent.right)) + 1;
        return newParent;
    }

    private AvlNode<T> leftRightRotation(AvlNode<T> oldParent) {
        oldParent.left = rightRightRotation(oldParent.left);
        return leftLeftRotation(oldParent);
    }

    private AvlNode<T> rightLeftRotation(AvlNode<T> oldParent) {
        oldParent.right = leftLeftRotation(oldParent.right);
        return rightRightRotation(oldParent);
    }

    private AvlNode<T> insert(AvlNode<T> parent, T element) {
        if (parent == null) {
            parent = new AvlNode<>(element, null, null);
        } else {
            int result = element.compareTo(parent.element);
            if (result < 0) {
                parent.left = insert(parent.left, element);
                if (height(parent.left) - height(parent.right) == 2) {
                    if (element.compareTo(parent.left.element) < 0) {
                        parent = leftLeftRotation(parent);
                    } else {
                        parent = leftRightRotation(parent);
                    }
                }
            } else if (result > 0) {
                parent.right = insert(parent.right, element);
                if (height(parent.right) - height(parent.left) == 2) {
                    if (element.compareTo(parent.right.element) > 0) {
                        parent = rightRightRotation(parent);
                    } else {
                        parent = rightLeftRotation(parent);
                    }
                }
            } else {
                System.out.print("该值已存在！");
            }
        }
        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        return parent;
    }

    public void insert(T value) {
        mRoot = insert(mRoot, value);
    }

    private AvlNode<T> maximum(AvlNode<T> parent) {
        if (parent == null) {
            return null;
        }
        if (parent.right != null) {
            return maximum(parent.right);
        } else {
            return parent;
        }
    }

    private AvlNode<T> minimum(AvlNode<T> parent) {
        if (parent == null) {
            return null;
        }
        if (parent.left != null) {
            return minimum(parent.left);
        } else {
            return parent;
        }
    }

    private AvlNode<T> remove(AvlNode<T> tree, AvlNode<T> target) {
        if (tree == null || target == null) {
            return null;
        }
        int result = target.element.compareTo(tree.element);
        if (result < 0) {
            tree.left = remove(tree.left, target);
            AvlNode<T> r = tree.right;
            if (height(r) - height(tree.left) == 2) {
                if (height(r.left) < height(r.right)) {
                    rightRightRotation(tree);
                } else {
                    rightLeftRotation(tree);
                }
            }
        } else if (result > 0) {
            tree.right = remove(tree.right, target);
            AvlNode<T> l = tree.left;
            if (height(l) - height(tree.right) == 2) {
                if (height(l.left) > height(l.right)) {
                    leftLeftRotation(tree);
                } else {
                    leftRightRotation(tree);
                }
            }
        } else {
            if (tree.left != null && tree.right != null) {
                if (height(tree.left) > height(tree.right)) {
                    AvlNode<T> max = maximum(tree.left);
                    tree.element = max.element;
                    tree.left = remove(tree.left, max);
                } else {
                    AvlNode<T> min = minimum(tree.right);
                    tree.element = min.element;
                    tree.right = remove(tree.right, min);
                }
            } else {
                tree = tree.left != null ? tree.left : tree.right;
            }
        }
        return tree;
    }

    public void remove(T element) {
        AvlNode<T> target = search(mRoot, element);
        if (target != null) {
            remove(mRoot, target);
        }
    }

    private AvlNode<T> search(AvlNode<T> parent, T element) {
        if (parent == null || element == null) {
            return null;
        }
        int result = element.compareTo(parent.element);
        if (result > 0) {
            return search(parent.right, element);
        } else if (result < 0) {
            return search(parent.left, element);
        } else {
            return parent;
        }
    }

    private void preOrder(AvlNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.element + "");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    private void midOrder(AvlNode<T> tree) {
        if (tree != null) {
            midOrder(tree.left);
            System.out.print(tree.element + "");
            midOrder(tree.right);
        }
    }

    public void midOrder() {
        midOrder(mRoot);
    }

    private void postOrder(AvlNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.element + "");
        }
    }
}
