package net.mlgmag.Spring_Crud.service.serviceImpl;

//@Service
//public class SecurityServiceImpl implements SecurityService {
//
//    private AuthenticationManager authenticationManager;
//
//    private final UserDetailsService userDetailsService;
//
//    @Autowired
//    public SecurityServiceImpl(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    public String findLoggedInUsername() {
//        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
//        if (userDetails instanceof UserDetails) {
//            return ((UserDetails) userDetails).getUsername();
//        }
//
//        return null;
//    }
//
//    @Override
//    public void autoLogin(String username, String password) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//
//        authenticationManager.authenticate(authenticationToken);
//
//        if (authenticationToken.isAuthenticated()){
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        }
//    }
//
//}
