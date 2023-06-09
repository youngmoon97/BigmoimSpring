package com.bigmoim.config.security;

import com.bigmoim.module.member.entity.MemberEntity;
import com.bigmoim.module.member.entity.RoleEntity;
import com.bigmoim.module.member.repository.MemberRepository;
import com.bigmoim.module.member.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

// UserDatailsService가 기존에 있음
//  시큐리티 디펜던시 추가했을 때 로그인 돼었음 user라는 아이디로
// Service라고 붙이면 UserDetailsService 중에서 하나만 뜬다.
// Bean또는 Component는 interface 기준으로 하나만 떠야한다.
@Service
@Primary // 중복되는 component 중에서 1순위로 IOC컨테이너에 등록된다.
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    // DI 방법
    // 1. @Autowired
    // 2. setter
    // 3. 생성자
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    // 로그인 단계
    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        // username으로 DB에 해당하는 userEntity가 있는지 확인
        // userEntity가 null이면 아이디를 잘못 친것이니 에러를 터트린다
        // userEntity가 null이 아니면
        // UserEntity와 UserRoleEntity로 UserDetails를 만들어서 리턴한다.

        MemberEntity memberEntity = memberRepository.getMember(memberId);

        if(memberEntity == null) {
            throw new UsernameNotFoundException("아이디를 정확히 입력해주세요.");
        }
        List<RoleEntity> roleEntityList = roleRepository.findById(memberEntity.getMemberId());

        //        if(userRoleEntityList.size() < 1){
//            throw new AuthenticationCredentialsNotFoundException("권한이 없습니다,");
//        }

        return new CustomUserDetails(memberEntity,roleEntityList);
    }
}
