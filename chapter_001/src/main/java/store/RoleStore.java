package store;

public class RoleStore<Role extends Base> implements Store<Role> {

    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(Role model) {
        this.store.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return this.store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return this.store.delete(id);
    }

    @Override
    public Role findById(String id) {
        return this.store.findById(id);
    }
}